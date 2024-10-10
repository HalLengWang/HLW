package com.todorank.hlw.domain.todo_list.repository;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findByUser(SiteUser user);
}
