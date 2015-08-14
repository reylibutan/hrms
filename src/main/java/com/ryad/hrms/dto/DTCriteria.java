package com.ryad.hrms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.Validate;

import com.ryad.hrms.dto.DTColumnDef.SortDirection;
import com.ryad.hrms.utility.DTConstants;
import com.ryad.hrms.utility.DTStringUtil;

/**
 * @author GO-VA
 *
 */
public class DTCriteria implements Serializable {

	private static final long serialVersionUID = 8661357461501153387L;

	private static final Logger LOG = LoggerFactory.getLogger(DTCriteria.class);

	private static Pattern pattern = Pattern.compile("columns\\[([0-9]*)?\\]");
	private final String search;
	private final Integer start;
	private final Integer length;
	private final List<DTColumnDef> columnDefs;
	private final List<DTColumnDef> sortedColumnDefs;
	private final Integer draw;
	private final Map<String, String> customFilters = new HashMap<String, String>();

	private DTCriteria(String search, Integer displayStart,
			Integer displaySize, List<DTColumnDef> columnDefs,
			List<DTColumnDef> sortedColumnDefs, Integer draw) {
		this.search = search;
		this.start = displayStart;
		this.length = displaySize;
		this.columnDefs = columnDefs;
		this.sortedColumnDefs = sortedColumnDefs;
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getLength() {
		return length;
	}

	public String getSearch() {
		return search;
	}

	public Integer getDraw() {
		return draw;
	}

	public List<DTColumnDef> getColumnDefs() {
		return columnDefs;
	}

	/**
	 * @return all sorted columns.
	 */
	public List<DTColumnDef> getSortedColumnDefs() {
		return sortedColumnDefs;
	}

	/**
	 * @return {@code true} if one the columns is searchable, {@code false}
	 *         otherwise.
	 */
	public Boolean hasOneSearchableColumn() {
		for (DTColumnDef columnDef : this.columnDefs) {
			if (columnDef.isSearchable()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return true if a column is being filtered, false otherwise.
	 */
	public Boolean hasOneFilteredColumn() {
		for (DTColumnDef columnDef : this.columnDefs) {
			if (DTStringUtil.isNotBlank(columnDef.getSearch())
					|| DTStringUtil.isNotBlank(columnDef.getSearchFrom())
					|| DTStringUtil.isNotBlank(columnDef.getSearchTo())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return true if a column is being sorted, false otherwise.
	 */
	public Boolean hasOneSortedColumn() {
		return !sortedColumnDefs.isEmpty();
	}

	/**
	 * <p>
	 * Map all request parameters into a wrapper POJO that eases SQL querying.
	 * </p>
	 * 
	 * @param request
	 *            The request sent by Datatables containing all parameters.
	 * @return a wrapper POJO.
	 */
	public static DTCriteria getFromRequest(HttpServletRequest request) {

		Validate.notNull(request, "The HTTP request cannot be null");

		int columnNumber = getColumnNumber(request);
		LOG.trace("Number of columns: {}", columnNumber);

		String paramSearch = request.getParameter(DTConstants.DT_S_SEARCH);
		String paramDraw = request.getParameter(DTConstants.DT_I_DRAW);
		String paramStart = request.getParameter(DTConstants.DT_I_START);
		String paramLength = request.getParameter(DTConstants.DT_I_LENGTH);

		Integer draw = DTStringUtil.isNotBlank(paramDraw) ? Integer
				.parseInt(paramDraw) : -1;
		Integer start = DTStringUtil.isNotBlank(paramStart) ? Integer
				.parseInt(paramStart) : -1;
		Integer length = DTStringUtil.isNotBlank(paramLength) ? Integer
				.parseInt(paramLength) : -1;

		// Column definitions
		List<DTColumnDef> columnDefs = new ArrayList<DTColumnDef>();

		for (int i = 0; i < columnNumber; i++) {

			DTColumnDef columnDef = new DTColumnDef();

			columnDef.setName(request.getParameter("columns[" + i + "][data]"));
			columnDef.setSearchable(Boolean.parseBoolean(request
					.getParameter("columns[" + i + "][searchable]")));
			columnDef.setSortable(Boolean.parseBoolean(request
					.getParameter("columns[" + i + "][orderable]")));
			columnDef.setRegex(request.getParameter("columns[" + i
					+ "][search][regex]"));

			String searchTerm = request.getParameter("columns[" + i
					+ "][search][value]");

			if (DTStringUtil.isNotBlank(searchTerm)) {
				columnDef.setFiltered(true);
				String[] splittedSearch = searchTerm.split("~");
				if ("~".equals(searchTerm)) {
					columnDef.setSearch("");
				} else if (searchTerm.startsWith("~")) {
					columnDef.setSearchTo(splittedSearch[1]);
				} else if (searchTerm.endsWith("~")) {
					columnDef.setSearchFrom(splittedSearch[0]);
				} else if (searchTerm.contains("~")) {
					columnDef.setSearchFrom(splittedSearch[0]);
					columnDef.setSearchTo(splittedSearch[1]);
				} else {
					columnDef.setSearch(searchTerm);
				}
			}

			for (int j = 0; j < columnNumber; j++) {
				String ordered = request.getParameter("order[" + j
						+ "][column]");
				if (ordered != null && ordered.equals(String.valueOf(i))) {
					columnDef.setSorted(true);
					break;
				}
			}

			columnDefs.add(columnDef);
		}

		// Sorted column definitions
		List<DTColumnDef> sortedColumnDefs = new LinkedList<DTColumnDef>();

		for (int i = 0; i < columnNumber; i++) {
			String paramSortedCol = request.getParameter("order[" + i
					+ "][column]");

			// The column is being sorted
			if (DTStringUtil.isNotBlank(paramSortedCol)) {
				Integer sortedCol = Integer.parseInt(paramSortedCol);
				DTColumnDef sortedColumnDef = columnDefs.get(sortedCol);
				String sortedColDirection = request.getParameter("order[" + i
						+ "][dir]");
				if (DTStringUtil.isNotBlank(sortedColDirection)) {
					sortedColumnDef.setSortDirection(SortDirection
							.valueOf(sortedColDirection.toUpperCase()));
				}

				sortedColumnDefs.add(sortedColumnDef);
			}
		}

		return new DTCriteria(paramSearch, start, length, columnDefs,
				sortedColumnDefs, draw);
	}

	private static int getColumnNumber(HttpServletRequest request) {

		int columnNumber = 0;
		for (Enumeration<String> e = request.getParameterNames(); e
				.hasMoreElements();) {
			String param = e.nextElement();
			Matcher matcher = pattern.matcher(param);
			while (matcher.find()) {
				Integer col = Integer.parseInt(matcher.group(1));
				if (col > columnNumber) {
					columnNumber = col;
				}
			}
		}

		if (columnNumber != 0) {
			columnNumber++;
		}
		return columnNumber;
	}

	@Override
	public String toString() {
		return "DTCriteria [search=" + search + ", start=" + start
				+ ", length=" + length + ", columnDefs=" + columnDefs
				+ ", sortingColumnDefs=" + sortedColumnDefs + ", draw=" + draw
				+ "]";
	}
	
	// ========================================================================
	// Custom implementation start
	//		- custom filters
	// ========================================================================
	public Map<String, String> getCustomFilters() {
		return customFilters;
	}
		
	public static void extractCustomFilters(DTCriteria criteria, HttpServletRequest request, String[] customFilterNames) {
		Map<String, String> customFilters = new HashMap<String, String>();
		
		for(String name : customFilterNames) {
			customFilters.put(name, request.getParameter(name));
		}
		
		criteria.getCustomFilters().putAll(customFilters);
	}
}