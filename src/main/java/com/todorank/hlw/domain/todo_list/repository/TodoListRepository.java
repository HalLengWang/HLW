package com.todorank.hlw.domain.todo_list.repository;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.user.entity.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findByUser(SiteUser user);
    Page<TodoList> findByUser(SiteUser user, Pageable pageable);
    Optional<TodoList> findByUserAndExecuteDate(SiteUser user, LocalDate executionDate);
}
