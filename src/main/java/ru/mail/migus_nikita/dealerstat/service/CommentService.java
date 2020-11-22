package ru.mail.migus_nikita.dealerstat.service;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.dto.CommentDto;
import ru.mail.migus_nikita.dealerstat.model.Comment;

public interface CommentService {

    void addCommentToPost(CommentDto commentDto);

    List<Comment> getCommentsByPostId(int postId);

}
