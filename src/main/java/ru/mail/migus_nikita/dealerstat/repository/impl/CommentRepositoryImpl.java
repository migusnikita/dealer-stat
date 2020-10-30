package ru.mail.migus_nikita.dealerstat.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.repository.CommentRepository;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    private SessionFactory sessionFactory;

//    @Autowired
//    public CommentRepositoryImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public Comment getById(int id) {
        return sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public void updateComment(Comment comment) {

    }

}
