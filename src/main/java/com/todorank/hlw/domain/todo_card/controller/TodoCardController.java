package com.todorank.hlw.domain.todo_card.controller;

import com.todorank.hlw.domain.todo_card.form.TodoCardForm;
import com.todorank.hlw.domain.todo_card.service.TodoCardService;
import com.todorank.hlw.domain.todo_list.DTO.TodoListDTO;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.domain.todo_type_list.service.TodoTypeListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo_card")
public class TodoCardController {
    private final TodoCardService todoCardService;
    private final TodoTypeListService todoTypeListService;
    private final TodoListService todoListService;

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String todoCardCreate(TodoCardForm todoCardForm, Model model,
                                 @RequestParam(value = "id") Long id , Principal principal) {
        TodoListDTO todoList = this.todoListService.getTodoList(id);
        if (!todoList.getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올바르지 못한 접근 입니다.");
        }
        List<TodoTypeList> typeList = this.todoTypeListService.getList();
        model.addAttribute("todoTypeList", typeList);
        model.addAttribute("todoListId", id);
        return "todo_card_read_create_page";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String todoCardCreate(@Valid TodoCardForm todoCardForm, BindingResult bindingResult,
                                 @RequestParam(value = "id") Long id, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "todo_card_read_create_page";
        }
        TodoListDTO todoList = this.todoListService.getTodoList(id);
        if (!todoList.getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올바르지 못한 접근 입니다.");
        }
        //TODO : 데이터 받아오고 저장하는 코드 추가
        return "redirect:/todo_list/detail/" + id;
    }
}
