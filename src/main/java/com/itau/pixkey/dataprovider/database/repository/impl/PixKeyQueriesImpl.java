package com.itau.pixkey.dataprovider.database.repository.impl;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.dataprovider.database.repository.PixKeyQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PixKeyQueriesImpl implements PixKeyQueries {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<PixKey> findBy(final KeyType keyType, final Integer agency, final Integer accountNumber, final String holderName, final OffsetDateTime registrationDate, final OffsetDateTime inactivationDate) {
        var builder = entityManager.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(PixKey.class);
        var root = criteriaQuery.from(PixKey.class);
        root.join("Account");

        List<Predicate> predicates = new ArrayList<>();

        if (keyType != null) {
            var keyTypePredicate = builder.equal(root.get("keyType"), keyType);
            predicates.add(keyTypePredicate);
        }

        if (agency != null) {
            var agencyPredicate = builder.equal(root.join("agency"), agency);
            predicates.add(agencyPredicate);
        }

        if (accountNumber != null) {
            var agencyPredicate = builder.equal(root.join("accountNumber"), accountNumber);
            predicates.add(agencyPredicate);
        }

        if (registrationDate != null) {
            var registrationDatePredicate = builder.equal(root.get("registrationDate"), registrationDate);
            predicates.add(registrationDatePredicate);
        }

        if (inactivationDate != null) {
            var inactivationDatePredicate = builder.equal(root.get("inactivationDate"), inactivationDate);
            predicates.add(inactivationDatePredicate);
        }

        if (StringUtils.hasText(holderName)) {
            var nomePredicate = builder.like(root.join("holderName"), "%" + holderName + "%");
            predicates.add(nomePredicate);
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
