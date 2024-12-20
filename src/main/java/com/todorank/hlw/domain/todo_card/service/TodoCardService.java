package com.todorank.hlw.domain.todo_card.service;

import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.form.TodoCardForm;
import com.todorank.hlw.domain.todo_card.repository.TodoCardRepository;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoCardService {
    private final TodoCardRepository todoCardRepository;

    @Transactional
    public TodoCard create(TodoCardForm todoCardForm, TodoTypeList type, TodoList todoList) {
        TodoCard todoCard = TodoCard.builder()
                .todoList(todoList)
                .title(todoCardForm.getTitle())
                .memo(todoCardForm.getMemo())
                .startTime(todoCardForm.getStartTime())
                .endTime(todoCardForm.getEndTime())
                .completion(todoCardForm.getCompletion())
                .execution(todoCardForm.getExecution())
                .todoTypeList(type)
                .build();
        this.todoCardRepository.save(todoCard);
        return todoCard;
    }

    public Page<TodoCard> getPage(TodoList todoList, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.asc("startTime"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.todoCardRepository.findByTodoList(todoList, pageable);
    }

    public TodoCard getCard(Long id) {
        return this.todoCardRepository.findById(id).orElse(null);
    }

    @Transactional
    public TodoCard modify(TodoCardForm todoCardForm, TodoCard todoCard, TodoTypeList type) {
        TodoCard modCard = todoCard.toBuilder()
                .title(todoCardForm.getTitle())
                .memo(todoCardForm.getMemo())
                .startTime(todoCardForm.getStartTime())
                .endTime(todoCardForm.getEndTime())
                .completion(todoCardForm.getCompletion())
                .execution(todoCardForm.getExecution())
                .todoTypeList(type)
                .build();
        this.todoCardRepository.save(modCard);
        return modCard;
    }

    @Transactional
    public void delete(TodoCard todoCard) {
        this.todoCardRepository.delete(todoCard);
    }
}