package ru.mail.migus_nikita.dealerstat.repository;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.model.Comment;

public interface CommentRepository {

    List<Comment> getAllComments();

    Comment getById(int id);

    void addComment(Comment comment);

    void deleteComment(Comment comment);

    void updateComment(Comment comment);

}
