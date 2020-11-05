package ru.mail.migus_nikita.dealerstat.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.repository.TraderInfoRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class TraderInfoRepositoryImpl implements TraderInfoRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<TraderInfo> getTraderByStatus(TraderInfoStatus traderInfoStatus) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TraderInfo> criteriaQuery = criteriaBuilder.createQuery(TraderInfo.class);
        Root<TraderInfo> root = criteriaQuery.from(TraderInfo.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("traderStatus"), traderInfoStatus)).select(root);

        TypedQuery<TraderInfo> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void addTrader(TraderInfo traderInfo) {
        entityManager.persist(traderInfo);
    }

    @Override
    public void changeStatusTrader(int id, TraderInfoStatus traderInfoStatus) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TraderInfo> criteriaQuery = criteriaBuilder.createQuery(TraderInfo.class);
        Root<TraderInfo> root = criteriaQuery.from(TraderInfo.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id)).select(root);

        TypedQuery<TraderInfo> typedQuery = entityManager.createQuery(criteriaQuery);
        TraderInfo traderInfo = typedQuery.getSingleResult();
        traderInfo.setTraderStatus(traderInfoStatus);

    }



}
