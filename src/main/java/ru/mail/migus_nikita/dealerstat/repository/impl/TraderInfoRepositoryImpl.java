package ru.mail.migus_nikita.dealerstat.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.repository.TraderInfoRepository;
import ru.mail.migus_nikita.dealerstat.util.HibernateUtil;

@Repository
@Transactional
public class TraderInfoRepositoryImpl implements TraderInfoRepository {

//    private SessionFactory sessionFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<TraderInfo> getTraderWaitingForApproved() {
        Session session = HibernateUtil.getHibernateSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TraderInfo> criteriaQuery = criteriaBuilder.createQuery(TraderInfo.class);
        Root<TraderInfo> root = criteriaQuery.from(TraderInfo.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("traderStatus"), TraderInfoStatus.WAITING_TO_APPROVE)).select(root);

        Query<TraderInfo> query = session.createQuery(criteriaQuery);
        List<TraderInfo> results = query.getResultList();
        return results;
    }

//    @Override
//    public void addTrader(TraderInfo traderInfo) {
//        sessionFactory.getCurrentSession().persist(traderInfo);
//    }
//
//    @Override
//    public void updateTrader(TraderInfo traderInfo) {
//        sessionFactory.getCurrentSession().update(traderInfo);
//    }

}
