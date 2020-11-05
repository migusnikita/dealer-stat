package ru.mail.migus_nikita.dealerstat.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.repository.CommentRepository;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public List<Comment> getCommentForTrader(TraderInfo traderInfo) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
        Root<Comment> root = criteriaQuery.from(Comment.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), traderInfo)).select(root);

        TypedQuery<Comment> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
