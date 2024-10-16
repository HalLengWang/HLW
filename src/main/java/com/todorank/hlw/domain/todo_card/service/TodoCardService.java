package com.todorank.hlw.domain.todo_card.service;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.repository.TodoCardRepository;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Page<TodoCard> getPage(TodoList todoList, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.asc("startDateTime"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.todoCardRepository.findByTodoList(todoList, pageable);
    }
}
