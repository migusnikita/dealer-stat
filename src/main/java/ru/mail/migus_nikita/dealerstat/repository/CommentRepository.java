package ru.mail.migus_nikita.dealerstat.repository;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.dictionary.CommentStatus;
import ru.mail.migus_nikita.dealerstat.model.Comment;

public interface CommentRepository {

    void addComment(Comment comment);

    void updateComment(Comment comment);

    List<Comment> getCommentForTrader(int traderInfo);

    List<Comment> getCommentsByStatus(CommentStatus commentStatus);

}
