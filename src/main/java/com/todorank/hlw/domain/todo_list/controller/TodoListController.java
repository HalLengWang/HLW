package com.todorank.hlw.domain.todo_list.controller;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo_list")
public class TodoListController {
    private final TodoListService todoListService;
    private final UserService userService;

    @GetMapping("/list")
    @PreAuthorize("isAuthenticated")
    public String list(Principal principal) {
        SiteUser user = this.userService.getUser(principal.getName());
        if (user == null) {
            return "redirect:/";
        }
        List<TodoList> todoLists = this.todoListService.getLists(user.getId());
        return "todo_list";
    }
}
