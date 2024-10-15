package com.todorank.hlw.domain.todo_card.repository;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoCardRepository extends JpaRepository<TodoCard, Long> {
    Page<TodoCard> findByTodoList(TodoList todoList, Pageable pageable);
}
