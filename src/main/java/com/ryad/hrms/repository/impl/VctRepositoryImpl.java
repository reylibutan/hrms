package com.ryad.hrms.repository.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.ryad.hrms.dto.DTColumnDef;
import com.ryad.hrms.dto.DTCriteria;
import com.ryad.hrms.entity.Vct;
import com.ryad.hrms.repository.VctRepositoryCustom;

public class VctRepositoryImpl implements VctRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vct> findVctWithDatatablesCriteria(DTCriteria criteria) {
		StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Vct p");
		
		// Step 1.9: custom search
		queryBuilder.append(getCustomFilterQuery(criteria));

		// Step 2: sorting
		if (criteria.hasOneSortedColumn()) {

			List<String> orderParams = new ArrayList<String>();
			queryBuilder.append(" ORDER BY ");
			for (DTColumnDef columnDef : criteria.getSortedColumnDefs()) {
				// custom sorting
				if("fullName".equals(columnDef.getName())) {
					orderParams.add("p.patient.firstName || ' ' || p.patient.lastName " + columnDef.getSortDirection());
				} else {
					orderParams.add("p." + columnDef.getName() + " " + columnDef.getSortDirection());
				}
			}

			Iterator<String> itr2 = orderParams.iterator();
			while (itr2.hasNext()) {
				queryBuilder.append(itr2.next());
				if (itr2.hasNext()) {
					queryBuilder.append(" , ");
				}
			}
		} else {
			queryBuilder.append(" ORDER BY id DESC");
		}

		TypedQuery<Vct> query = entityManager.createQuery(queryBuilder.toString(), Vct.class);

		// Step 3: paging
		query.setFirstResult(criteria.getStart());
		query.setMaxResults(criteria.getLength());

		return query.getResultList();
	}

	public Long getFilteredCount(DTCriteria criteria) {

		StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Vct p");
		
		// custom search
		queryBuilder.append(getCustomFilterQuery(criteria));

		Query query = entityManager.createQuery(queryBuilder.toString());
		return Long.parseLong(String.valueOf(query.getResultList().size()));
	}
	
	private StringBuilder getCustomFilterQuery(DTCriteria criteria) {
		StringBuilder queryBuilder = new StringBuilder();
		List<String> paramList = new ArrayList<String>();

		for (Entry<String, String> entry : criteria.getCustomFilters().entrySet()) {
			String filter = entry.getKey();
			String filterVal = entry.getValue();
			
			if(!(filterVal == null || filterVal.isEmpty())) {				
				if("vctName".equals(filter)) {
					filterVal = filterVal.toLowerCase();
					paramList.add(
							" (LOWER(p.patient.firstName || ' ' || p.patient.lastName) LIKE '%?%'".replace("?", filterVal) + ")" + 
							" OR " + 
							" (p.patient.firstName || ' ' || p.patient.middleName || ' ' || p.patient.lastName) LIKE '%?%'".replace("?", filterVal) + ")");
				} else if("uniqueIdCode".equals(filter)) {
					filterVal = filterVal.toLowerCase();
					paramList.add(" LOWER(p.patient." + filter + ") LIKE '%?%'".replace("?", filterVal));
				} else {
					paramList.add(" LOWER(p." + filter + ") LIKE '%?%'".replace("?", filterVal));
				}
			}
		}

		if(!paramList.isEmpty()) {
			queryBuilder.append(" WHERE ");
			
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