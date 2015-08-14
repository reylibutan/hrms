package com.ryad.hrms.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ryad.hrms.dto.DTColumnDef;
import com.ryad.hrms.dto.DTCriteria;

public class DTUtil {

	/**
	 * 
	 * @param select
	 * @param criteria
	 * @return
	 */
	public static StringBuilder getFilterQuery(DTCriteria criteria) {
		StringBuilder queryBuilder = new StringBuilder();
		List<String> paramList = new ArrayList<String>();
		
		// Step 1.1: global filtering
		if (DTStringUtil.isNotBlank(criteria.getSearch()) && criteria.hasOneSearchableColumn()) {
			queryBuilder.append(" WHERE ");

			for (DTColumnDef columnDef : criteria.getColumnDefs()) {
				if (columnDef.isSearchable() && DTStringUtil.isBlank(columnDef.getSearch())) {
					paramList.add(" LOWER(p." + columnDef.getName()
							+ ") LIKE '%?%'".replace("?", criteria.getSearch().toLowerCase()));
				}
			}

			Iterator<String> itr = paramList.iterator();
			while (itr.hasNext()) {
				queryBuilder.append(itr.next());
				if (itr.hasNext()) {
					queryBuilder.append(" OR ");
				}
			}
		}

		// Step 1.2: individual column filtering
		if (criteria.hasOneSearchableColumn() && criteria.hasOneFilteredColumn()) {
			paramList = new ArrayList<String>();
			
			if(!queryBuilder.toString().contains("WHERE")){
				queryBuilder.append(" WHERE ");
			}
			else{
				queryBuilder.append(" AND ");
			}

			for (DTColumnDef columnDef : criteria.getColumnDefs()) {
				if (columnDef.isSearchable()){
					if (DTStringUtil.isNotBlank(columnDef.getSearchFrom())) {
						if (columnDef.getName().equalsIgnoreCase("birthDate")) {
							paramList.add("p." + columnDef.getName() + " >= '" + columnDef.getSearchFrom() + "'");
						}
						else {
							paramList.add("p." + columnDef.getName() + " >= " + columnDef.getSearchFrom());
						}
					}

					if (DTStringUtil.isNotBlank(columnDef.getSearchTo())) {
						if (columnDef.getName().equalsIgnoreCase("birthDate")) {
							paramList.add("p." + columnDef.getName() + " < '" + columnDef.getSearchTo() + "'");
						}
						else {
							paramList.add("p." + columnDef.getName() + " < " + columnDef.getSearchTo());
						}
					}
					
					if(DTStringUtil.isNotBlank(columnDef.getSearch())) {
						paramList.add(" LOWER(p." + columnDef.getName()
								+ ") LIKE '%?%'".replace("?", columnDef.getSearch().toLowerCase()));
					}
				}
			}

			Iterator<String> itr = paramList.iterator();
			while (itr.hasNext()) {
				queryBuilder.append(itr.next());
				if (itr.hasNext()) {
					queryBuilder.append(" AND ");
				}
			}
		}
		
		return queryBuilder;
	}
}
