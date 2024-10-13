package com.todorank.hlw.domain.todo_list.service;

import com.todorank.hlw.domain.todo_list.DTO.TodoListDTO;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.repository.TodoListRepository;
import com.todorank.hlw.domain.user.entity.SiteUser;
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
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public Page<TodoList> getPage(SiteUser user, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdDate"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.todoListRepository.findByUser(user, pageable);
    }

    public TodoListDTO getTodoList(Long id) {
        TodoList todoList = this.todoListRepository.findById(id).orElse(null);
        if (todoList == null) {
            return null;
        }
        return TodoListDTO.builder()
                .id(todoList.getId())
                .createdDate(todoList.getCreatedDate())
                .modifiedDate(todoList.getModifiedDate())
                .title(todoList.getTitle())
                .remembrance(todoList.getRemembrance())
                .userId(todoList.getUser().getId())
                .username(todoList.getUser().getUsername())
                .build();
    public List<TodoList> getLists(SiteUser user) {
        return this.todoListRepository.findByUser(user);
    }
}
