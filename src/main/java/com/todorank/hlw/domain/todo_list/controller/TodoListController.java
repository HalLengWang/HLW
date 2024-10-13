package com.todorank.hlw.domain.todo_list.controller;

import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String list(Principal principal, Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "id", required = false) Long user_id) {
        SiteUser user = null;
        if (user_id != null) {
            user = this.userService.getUser(user_id);
        } else {
            user = this.userService.getUser(principal.getName());
        }
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다.");
        }

        Page<TodoList> todoLists = this.todoListService.getPage(user, page);
        model.addAttribute("paging", todoLists);
        model.addAttribute("page", page);
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("id", user_id);
        return "todo_list";
    }

   /* @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create() {

    }*/
}
