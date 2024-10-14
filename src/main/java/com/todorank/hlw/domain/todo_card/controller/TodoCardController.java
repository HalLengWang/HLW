package com.todorank.hlw.domain.todo_card.controller;

import com.todorank.hlw.domain.todo_card.service.TodoCardService;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.domain.todo_type_list.service.TodoTypeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo_card")
public class TodoCardController {
    private final TodoCardService todoCardService;
    private final TodoTypeListService todoTypeListService;

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String todoCardCreate(Model model) {
        List<TodoTypeList> typeList = this.todoTypeListService.getList();
        model.addAttribute("todoTypeList", typeList);
        return "todo_card_read_create_page";
    }
}
