package com.todorank.hlw.domain.remembrance.entity;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Remembrance extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private TodoList todoList;

    private String remembrance;

    @ManyToMany
    private Set<SiteUser> votes;
}
