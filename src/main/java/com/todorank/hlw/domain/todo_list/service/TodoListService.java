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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public Page<TodoList> getPage(SiteUser user, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("executeDate"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.todoListRepository.findByUser(user, pageable);
    }

    public TodoList getTodoList(Long id) {
        return this.todoListRepository.findById(id).orElse(null);
    }

    public List<TodoList> getLists(SiteUser user) {
        return this.todoListRepository.findByUser(user);
    }

    // github 코드 create, modify
    public TodoList create(SiteUser user) {
        Optional<TodoList> optionalTodoList = this.todoListRepository.findByExecuteDate(LocalDate.now());
        int i = 0;
        while (optionalTodoList.isPresent()) {
            i++;
            optionalTodoList = this.todoListRepository.findByExecuteDate(LocalDate.now().plusDays(i));
        }
        TodoList todoList = TodoList.builder()
                .title("제목 없음")
                .user(user)
                .executeDate(LocalDate.now().plusDays(i))
                .build();
        this.todoListRepository.save(todoList);
        return todoList;
    }

    public void modify(TodoList todoList, String title) {
        TodoList modified = todoList.toBuilder()
                .title(title)
                .build();
        this.todoListRepository.save(modified);
    }

    public boolean updateExecuteDate(TodoList todoList, LocalDate date) {
        TodoList modList = todoList.toBuilder()
                .executeDate(date)
                .build();
        try {
            this.todoListRepository.save(modList);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}