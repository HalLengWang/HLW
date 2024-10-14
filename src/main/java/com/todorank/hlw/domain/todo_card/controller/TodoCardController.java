package com.todorank.hlw.domain.todo_card.controller;

import com.todorank.hlw.domain.todo_card.service.TodoCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo_card")
public class TodoCardController {
    private final TodoCardService todoCardService;

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String todoCardCreate() {
        return "todo_card_read_create_page";
    }
}
