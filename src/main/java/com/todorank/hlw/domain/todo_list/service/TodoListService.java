package com.todorank.hlw.domain.todo_list.service;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.repository.TodoListRepository;
import com.todorank.hlw.domain.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public List<TodoList> getLists(SiteUser user) {
        return this.todoListRepository.findByUser(user);
    }
}
