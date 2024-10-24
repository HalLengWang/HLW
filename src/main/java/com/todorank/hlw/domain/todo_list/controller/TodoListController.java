package com.todorank.hlw.domain.todo_list.controller;

import com.todorank.hlw.domain.remembrance.form.RemembranceForm;
import com.todorank.hlw.domain.remembrance_comment.service.RemembranceCommentService;
import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.service.TodoCardService;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo_list")
public class TodoListController {
    private final TodoListService todoListService;
    private final UserService userService;
    private final TodoCardService todoCardService;

    @GetMapping("/list/{id}")
    public String list(Principal principal, Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                       @PathVariable(value = "id", required = false) Long userId) {
        SiteUser user = null;
        if (userId == 0) {
            user = this.userService.getUser(principal.getName());
            userId = user.getId();
        } else {
            user = this.userService.getUser(userId);
        }
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다.");
        }

        Page<TodoList> todoLists = this.todoListService.getPage(user, page);
        model.addAttribute("paging", todoLists);
        model.addAttribute("page", page);
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("id", userId);
        return "todo_list";
    }

    @GetMapping("/detail/{id}")
    public String create(@PathVariable(value = "id") Long list_id, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page) {
        TodoList todoList = this.todoListService.getTodoList(list_id);
        if (todoList == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 리스트 입니다.");
        }
        Page<TodoCard> paging = this.todoCardService.getPage(todoList, page);
        model.addAttribute("paging", paging);
        model.addAttribute("username", todoList.getUser().getUsername());
        todoList.toBuilder().user(null).build();
        model.addAttribute("todoList", todoList);
        if (todoList.getRemembrance() != null) {
            if (todoList.getRemembrance().getComments().isEmpty()) {
                model.addAttribute("comments", null);
            } else {
                model.addAttribute("comments", todoList.getRemembrance().getComments());
            }
        }
        if (todoList.getRemembrance() != null) {
            remembranceForm.setContent(todoList.getRemembrance().getContent());
            remembranceForm.setTitle(todoList.getRemembrance().getTitle());
            remembranceForm.setIsPublic(todoList.getRemembrance().getIsPublic());
        }
        return "todo_list_detail";
    }

    // github 코드 getmapping create{id}, modify{id}
    @GetMapping("/create/{id}")
    @PreAuthorize("isAuthenticated()")
    public String create(@PathVariable(value = "id") Long userId, Principal principal) {
        SiteUser user = this.userService.getUser(userId);
        if (user == null || !user.getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "권한이 없습니다.");
        }
        TodoList todoList = this.todoListService.create(user);
        if (todoList.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 리스트 입니다.");
        }
        return "redirect:/todo_list/detail/" + todoList.getId();
    }

    @PostMapping("/modify/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public ResponseEntity<Map<String, String>> modify(@PathVariable(value = "id") Long listId, Principal principal,
                                                      @RequestParam(value = "title") String title) {
        TodoList todoList = this.todoListService.getTodoList(listId);
        if (todoList == null || !todoList.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "권한이 없습니다.");
        }
        this.todoListService.modify(todoList, title);

        Map<String, String> response = new HashMap<>();
        response.put("updatedTitle", title);
        return ResponseEntity.ok(response);
    }

}
