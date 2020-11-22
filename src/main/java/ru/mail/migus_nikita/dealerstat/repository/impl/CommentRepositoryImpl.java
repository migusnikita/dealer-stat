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
import ru.mail.migus_nikita.dealerstat.dictionary.CommentStatus;
import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.repository.CommentRepository;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    private final EntityManager entityManager;

    @Autowired
    public CommentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getCommentForTrader(int traderInfoId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
        Root<Comment> root = criteriaQuery.from(Comment.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), traderInfoId)).select(root);

        TypedQuery<Comment> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Comment> getCommentsByStatus(CommentStatus commentStatus) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
        Root<Comment> root = criteriaQuery.from(Comment.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("approved"), commentStatus)).select(root);

        TypedQuery<Comment> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
