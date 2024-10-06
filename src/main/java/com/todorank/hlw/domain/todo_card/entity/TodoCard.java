package com.todorank.hlw.domain.todo_card.entity;

import com.todorank.hlw.domain.score.entity.Score;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TodoCard extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id")
    private TodoList todoList;

    @ManyToOne
    @JoinColumn(name = "id")
    private TodoTypeList todoTypeList;

    private String title;

    @Column(columnDefinition = "text")
    private String memo;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private Boolean completion;

    private Integer execution;

    @OneToOne(mappedBy = "todoCard")
    private Score score;
}
