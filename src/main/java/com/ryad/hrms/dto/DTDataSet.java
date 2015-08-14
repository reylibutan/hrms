package com.ryad.hrms.dto;

import java.util.List;

public final class DTDataSet<T> {
	
	private final List<T> rows;
	private final Long totalDisplayRecords;
	private final Long totalRecords;

	public DTDataSet(List<T> rows, Long totalRecords, Long totalDisplayRecords) {
		this.rows = rows;
		this.totalRecords = totalRecords;
		this.totalDisplayRecords = totalDisplayRecords;
	}

	public List<T> getRows() {
		return rows;
	}

	public Long getTotalDisplayRecords() {
		return totalDisplayRecords;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}
}