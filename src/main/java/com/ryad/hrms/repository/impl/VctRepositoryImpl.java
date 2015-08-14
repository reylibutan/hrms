package com.ryad.hrms.repository.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.ryad.hrms.dto.DTColumnDef;
import com.ryad.hrms.dto.DTCriteria;
import com.ryad.hrms.entity.Vct;
import com.ryad.hrms.repository.VctRepositoryCustom;
import com.ryad.hrms.utility.DTUtil;

public class VctRepositoryImpl implements VctRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vct> findVctWithDatatablesCriteria(DTCriteria criteria) {
		StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Vct p");

		queryBuilder.append(DTUtil.getFilterQuery(criteria));

		// Step 2: sorting
		if (criteria.hasOneSortedColumn()) {

			List<String> orderParams = new ArrayList<String>();
			queryBuilder.append(" ORDER BY ");
			for (DTColumnDef columnDef : criteria.getSortedColumnDefs()) {
				orderParams.add("p." + columnDef.getName() + " "
						+ columnDef.getSortDirection());
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

		TypedQuery<Vct> query = entityManager.createQuery(
				queryBuilder.toString(), Vct.class);

		// Step 3: paging
		query.setFirstResult(criteria.getStart());
		query.setMaxResults(criteria.getLength());

		return query.getResultList();
	}

	public Long getFilteredCount(DTCriteria criterias) {

		StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Vct p");

		queryBuilder.append(DTUtil.getFilterQuery(criterias));

		Query query = entityManager.createQuery(queryBuilder.toString());
		return Long.parseLong(String.valueOf(query.getResultList().size()));
	}
}