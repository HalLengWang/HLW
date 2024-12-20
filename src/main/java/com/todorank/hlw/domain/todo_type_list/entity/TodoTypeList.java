package com.todorank.hlw.domain.todo_type_list.entity;

import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TodoTypeList extends BaseEntity {
    private String typeName;

    private Integer ratio;
}
