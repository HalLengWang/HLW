package com.todorank.hlw.domain.todo_list.entity;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TodoList extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "site_user_id")
    private SiteUser user;

    private String title;

    @OneToOne(mappedBy = "todoList")
    private Remembrance remembrance;
}
