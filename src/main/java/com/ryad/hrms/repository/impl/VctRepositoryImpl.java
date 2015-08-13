package com.ryad.hrms.repository.impl;

import com.ryad.hrms.repository.VctRepositoryCustom;

public class VctRepositoryImpl implements VctRepositoryCustom {

	/*@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vct> findVctWithDatatablesCriteria(DatatablesCriterias criteria) {
		StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Vct p");

		queryBuilder.append(DatatablesUtils.getFilterQuery(criteria));

		*//**
		 * Step 2: sorting
		 *//*
		if (criteria.hasOneSortedColumn()) {

			List<String> orderParams = new ArrayList<String>();
			queryBuilder.append(" ORDER BY ");
			for (ColumnDef columnDef : criteria.getSortedColumnDefs()) {
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
		}

		TypedQuery<Vct> query = entityManager.createQuery(
				queryBuilder.toString(), Vct.class);

		*//**
		 * Step 3: paging
		 *//*
		query.setFirstResult(criteria.getStart());
		query.setMaxResults(criteria.getLength());

		return query.getResultList();
	}

	public Long getFilteredCount(DatatablesCriterias criterias) {

		StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Vct p");

		queryBuilder.append(DatatablesUtils.getFilterQuery(criterias));

		Query query = entityManager.createQuery(queryBuilder.toString());
		return Long.parseLong(String.valueOf(query.getResultList().size()));
	}*/
}