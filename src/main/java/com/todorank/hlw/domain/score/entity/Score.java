package com.todorank.hlw.domain.score.entity;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Score extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "site_user_id")
    @NotNull
    private SiteUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_card_id")
    @NotNull
    private TodoCard todoCard;

    private String source;

    private Integer score;

}
