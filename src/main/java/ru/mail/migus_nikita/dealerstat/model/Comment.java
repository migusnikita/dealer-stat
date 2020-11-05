package ru.mail.migus_nikita.dealerstat.model;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;

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
    private Date createdAt;

    @Column(name = "approved")
    private int approved;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trader_info_id")
    private TraderInfo traderInfo;
}
