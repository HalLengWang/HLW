package com.todorank.hlw.domain.score.entity;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Score extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "site_user_id")
    private SiteUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_card_id")
    private TodoCard todoCard;

    private String source;

    private Integer score;
}
