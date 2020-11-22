package ru.mail.migus_nikita.dealerstat.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import ru.mail.migus_nikita.dealerstat.dictionary.CommentStatus;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(columnDefinition = "ENUM('WAITING_FOR_APPROVE','DECLINED','APPROVED')")
    @Enumerated(EnumType.STRING)
    private CommentStatus approved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trader_info_id")
    private TraderInfo traderInfo;

}
