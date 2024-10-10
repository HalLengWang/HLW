package com.todorank.hlw.domain.todo_list.service;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

   /* public List<TodoList> getLists(Long userId) {
        return this.todoListRepository.findBySiteUserId(userId);
    }*/
}
