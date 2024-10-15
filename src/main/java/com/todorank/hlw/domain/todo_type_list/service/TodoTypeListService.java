package com.todorank.hlw.domain.todo_type_list.service;

import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.domain.todo_type_list.repository.TodoTypeListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoTypeListService {
    private final TodoTypeListRepository todoTypeListRepository;

    public List<TodoTypeList> getList() {
        return this.todoTypeListRepository.findAll();
    }

    public TodoTypeList getOne(Long id) {
        return this.todoTypeListRepository.findById(id).orElse(null);
    }
}
