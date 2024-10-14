package com.todorank.hlw.domain.todo_card.service;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.repository.TodoCardRepository;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TodoCardService {
    private final TodoCardRepository todoCardRepository;

    public void create(String title, String memo, LocalDateTime startDateTime, LocalDateTime endDateTime,
                       Boolean completion, Integer execution, TodoTypeList todoType, TodoList todoList) {
        TodoCard todoCard = TodoCard.builder()
                .todoList(todoList)
                .title(title)
                .memo(memo)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .completion(completion)
                .execution(execution)
                .todoTypeList(todoType)
                .build();
        this.todoCardRepository.save(todoCard);
    }
}
