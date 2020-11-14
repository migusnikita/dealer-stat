package ru.mail.migus_nikita.dealerstat.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import ru.mail.migus_nikita.dealerstat.dictionary.CommentStatus;
import ru.mail.migus_nikita.dealerstat.dto.CommentDto;
import ru.mail.migus_nikita.dealerstat.model.Comment;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.repository.CommentRepository;
import ru.mail.migus_nikita.dealerstat.service.CommentService;
import ru.mail.migus_nikita.dealerstat.service.TraderInfoService;
import ru.mail.migus_nikita.dealerstat.service.UserService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private TraderInfoService traderInfoService;

    private UserService userService;

    @Override
    public void addCommentToPost(CommentDto commentDto) {

        Comment comment = new Comment();
        comment.setCommentStatus(CommentStatus.APPROVED);
        comment.setCreatedAt(LocalDate.now());
        comment.setMessage(commentDto.getText());

        TraderInfo traderInfo = traderInfoService.findById(commentDto.getPostId());

        comment.setTraderInfo(traderInfo);

        String author = commentDto.getAuthor();

        User byUserName = userService.findByUserName(author);
        comment.setUser(byUserName);

        commentRepository.addComment(comment);

    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {

        List<Comment> commentsForTrader = commentRepository.getCommentForTrader(postId);

        return commentsForTrader;
    }

}
