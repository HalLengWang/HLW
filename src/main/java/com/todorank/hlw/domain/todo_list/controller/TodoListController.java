package com.todorank.hlw.domain.todo_list.controller;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PreAuthorize("isAuthenticated()")
    public String list(Principal principal, Model model) {
        SiteUser user = this.userService.getUser(principal.getName());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다.");
        }
        List<TodoList> todoLists = this.todoListService.getLists(user);
        model.addAttribute("todoLists", todoLists);
        return "todo_list";
    }

   /* @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create() {

    }*/
}
