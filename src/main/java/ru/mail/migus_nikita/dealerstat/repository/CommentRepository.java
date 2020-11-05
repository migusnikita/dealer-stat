package ru.mail.migus_nikita.dealerstat.repository;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;

public interface CommentRepository {

    void addComment(Comment comment);

    void updateComment(Comment comment);

    List<Comment> getCommentForTrader(TraderInfo traderInfo);

}
