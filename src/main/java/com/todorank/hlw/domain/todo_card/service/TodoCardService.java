package com.todorank.hlw.domain.todo_card.service;

import com.todorank.hlw.domain.todo_card.repository.TodoCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoCardService {
    private final TodoCardRepository todoCardRepository;
}
