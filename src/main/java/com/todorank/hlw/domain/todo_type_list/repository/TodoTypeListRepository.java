package com.todorank.hlw.domain.todo_type_list.repository;

import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoTypeListRepository extends JpaRepository<TodoTypeList, Long> {
}
