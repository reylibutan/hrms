package com.ryad.hrms.dto;

import java.util.List;

public class DTResponse<T> {
	
	private final List<T> data;
	private final Long recordsTotal;
	private final Long recordsFiltered;
	private final Integer draw;

	private DTResponse(DTDataSet<T> dataSet, DTCriteria criterias) {
		this.data = dataSet.getRows();
		this.recordsTotal = dataSet.getTotalRecords();
		this.recordsFiltered = dataSet.getTotalDisplayRecords();
		this.draw = criterias.getDraw();
	}

	public List<T> getData() {
		return data;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public Integer getDraw() {
		return draw;
	}

	public static <T> DTResponse<T> build(DTDataSet<T> dataSet, DTCriteria criterias) {
		return new DTResponse<T>(dataSet, criterias);
	}
}