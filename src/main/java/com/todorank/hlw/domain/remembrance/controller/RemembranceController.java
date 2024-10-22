package com.todorank.hlw.domain.remembrance.controller;

import com.todorank.hlw.domain.remembrance.form.RemembranceForm;
import com.todorank.hlw.domain.remembrance.service.RemembranceService;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/remembrance")
public class RemembranceController {
    private final RemembranceService remembranceService;
    private final TodoListService todoListService;

    @PostMapping("/create/{id}")
    @PreAuthorize("isAuthenticated()")
    public String createRemembrance(@Valid RemembranceForm remembranceForm, BindingResult bindingResult,
                                    @PathVariable("id") Long listId, Principal principal, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessages", bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList()));
            return "redirect:/todo_list/detail/" + listId;
        }
        TodoList todoList = this.todoListService.getTodoList(listId);
        if (todoList == null || !todoList.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올바르지 못한 접근입니다.");
        }
        this.remembranceService.create(remembranceForm, todoList);
        return "redirect:/todo_list/detail/" + listId;
    }
}
