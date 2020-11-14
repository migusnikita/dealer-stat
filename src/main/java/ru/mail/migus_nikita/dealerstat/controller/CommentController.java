package ru.mail.migus_nikita.dealerstat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mail.migus_nikita.dealerstat.dto.CommentDto;
import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.service.CommentService;

public class CommentController {

    private CommentService commentService;

    @PostMapping("/post/add-comment")
    public void addComment(CommentDto commentDto) {
        commentService.addCommentToPost(commentDto);
    }

    @PostMapping("/post/get-comments-for-trader/{id}")
    public List<Comment> getCommentForTrader(@PathVariable int id) {
        return commentService.getCommentsByPostId(id);
    }

}

//1.conttoller
//      2.метод по добавлению комментов к посту
//    3.метод по выборке всех комментов к посту