package ru.mail.migus_nikita.dealerstat.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoCategory;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;

@Getter
@Setter
@Entity
@Table(name = "user")
public class TraderInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private TraderInfoStatus traderStatus;

    @Column(name = "category")
    private TraderInfoCategory traderCategory;

    @Column(name = "user_id")
    private String userId;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE,
            mappedBy = "traderInfo")
    private Set<Comment> comments;

}


