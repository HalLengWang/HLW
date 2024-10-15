package com.todorank.hlw.domain.todo_card.repository;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoCardRepository extends JpaRepository<TodoCard, Long> {
}
