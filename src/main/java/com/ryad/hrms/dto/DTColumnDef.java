package com.ryad.hrms.dto;

import java.io.Serializable;

public class DTColumnDef implements Serializable {

	private static final long serialVersionUID = 6349611254914115218L;
	private String name;
	private boolean sortable;
	private boolean sorted = false;
	private boolean searchable;
	private boolean filtered;
	private String regex;
	private String search;
	private String searchFrom;
	private String searchTo;
	private SortDirection sortDirection;

	public enum SortDirection {
		ASC, DESC;
	}

	public SortDirection getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSortable() {
		return sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchFrom() {
		return searchFrom;
	}

	public void setSearchFrom(String searchFrom) {
		this.searchFrom = searchFrom;
	}

	public String getSearchTo() {
		return searchTo;
	}

	public void setSearchTo(String searchTo) {
		this.searchTo = searchTo;
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public boolean isFiltered() {
		return filtered;
	}

	public void setFiltered(boolean filtered) {
		this.filtered = filtered;
	}

	@Override
	public String toString() {
		return "ColumnDef [name=" + name + ", sortable=" + sortable
				+ ", sorted=" + sorted + ", searchable=" + searchable
				+ ", filtered=" + filtered + ", regex=" + regex + ", search="
				+ search + ", searchFrom=" + searchFrom + ", searchTo="
				+ searchTo + ", sortDirection=" + sortDirection + "]";
	}
}
