package ru.mail.migus_nikita.dealerstat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.migus_nikita.dealerstat.dictionary.CommentStatus;
import ru.mail.migus_nikita.dealerstat.dto.CommentDto;
import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.repository.CommentRepository;
import ru.mail.migus_nikita.dealerstat.service.CommentService;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/post/add-comment")
    public void addComment(CommentDto commentDto) {
        commentService.addCommentToPost(commentDto);
    }

    @PostMapping("/post/get-comments-for-trader/{id}")
    public List<Comment> getCommentForTrader(@PathVariable int id) {
        return commentService.getCommentsByPostId(id);
    }

    @GetMapping("/get-comments-by-status/{status}")
    public List<Comment> getCommentByStatus(@PathVariable CommentStatus status) {
        return commentRepository.getCommentsByStatus(status);
    }

}

//1.conttoller
//      2.метод по добавлению комментов к посту
//    3.метод по выборке всех комментов к посту