package com.todorank.hlw.domain.todo_card.controller;

import com.todorank.hlw.domain.score.service.ScoreService;
import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.form.TodoCardForm;
import com.todorank.hlw.domain.todo_card.service.TodoCardService;
import com.todorank.hlw.domain.todo_list.DTO.TodoListDTO;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.domain.todo_type_list.service.TodoTypeListService;
import com.todorank.hlw.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo_card")
public class TodoCardController {
    private final TodoCardService todoCardService;
    private final TodoTypeListService todoTypeListService;
    private final TodoListService todoListService;
    private final ScoreService scoreService;
    private final UserService userService;

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String todoCardCreate(TodoCardForm todoCardForm, Model model,
                                 @RequestParam(value = "id") Long list_id, Principal principal) {
        TodoList todoList = this.todoListService.getTodoList(list_id);
        if (!todoList.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "권한이 없습니다.");
        }
        todoCardForm.setExecution(0);
        if (model.containsAttribute("todoCardForm")) {
            todoCardForm = (TodoCardForm) model.getAttribute("todoCardForm");
        }
        List<TodoTypeList> typeList = this.todoTypeListService.getList();
        model.addAttribute("todoTypeList", typeList);
        model.addAttribute("todoListId", list_id);
        // github 코드 2줄
        model.addAttribute("username", todoList.getUser().getUsername());
        model.addAttribute("mode", "create");
        return "todo_card_read_create_page";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String todoCardCreate(@Valid TodoCardForm todoCardForm, BindingResult bindingResult,
                                 @RequestParam(value = "id") Long list_id, Principal principal, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessages", bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList()));
            redirectAttributes.addFlashAttribute("todoCardForm", todoCardForm);
            return "redirect:/todo_card/create?id=" + list_id;
        }
        TodoList todoList = this.todoListService.getTodoList(list_id);
        if (!todoList.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올바르지 못한 접근 입니다.");
        }
        TodoTypeList type = todoTypeListService.getOne(todoCardForm.getCategory());
        TodoCard todoCard = this.todoCardService.create(todoCardForm, type, todoList);

        this.scoreService.create(todoCard, this.userService.getUser(principal.getName()));


        return String.format("redirect:/todo_list/detail/%s", list_id);
    }

    // github 코드 getmapping 1개, postmapping 2개
    @GetMapping("/detail/{id}")
    public String todoCardDetail(TodoCardForm todoCardForm, @PathVariable(value = "id") Long cardId,
                                 Model model, Principal principal) {
        TodoCard todoCard = this.todoCardService.getCard(cardId);
        List<TodoTypeList> typeList = this.todoTypeListService.getList();
        if (todoCard == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 데이터입니다.");
        }
        model.addAttribute("todoTypeList", typeList);
        model.addAttribute("username", todoCard.getTodoList().getUser().getUsername());
        model.addAttribute("mode", "detail");
        model.addAttribute("cardId", cardId);
        todoCardForm.setExecution(todoCard.getExecution());
        todoCardForm.setMemo(todoCard.getMemo());
        todoCardForm.setCategory(todoCard.getTodoTypeList().getId());
        todoCardForm.setTitle(todoCard.getTitle());
        todoCardForm.setCompletion(todoCard.getCompletion());
        todoCardForm.setEndTime(todoCard.getEndTime());
        todoCardForm.setStartTime(todoCard.getStartTime());
        return "todo_card_read_create_page";
    }

    @PostMapping("/detail/{id}")
    @PreAuthorize("isAuthenticated()")
    public String todoCardModify(@Valid TodoCardForm todoCardForm, BindingResult bindingResult,
                                 @PathVariable(value = "id") Long cardId, Principal principal, Model model) {
        if (bindingResult.hasErrors()) {
            return "todo_card_read_create_page";
        }
        TodoCard todoCard = this.todoCardService.getCard(cardId);
        if (todoCard == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 데이터입니다.");
        }
        if (!todoCard.getTodoList().getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "권한이 없습니다.");
        }
        TodoTypeList type = this.todoTypeListService.getOne(todoCardForm.getCategory());
        TodoCard todoCard1 = this.todoCardService.modify(todoCardForm, todoCard, type);

        this.scoreService.modify(todoCard1);
        model.addAttribute("success", true);
        return "redirect:/todo_card/detail/" + cardId;
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String todoCardDelete(@PathVariable(value = "id") Long cardId, TodoCardForm todoCardForm,
                                 Principal principal) {
        TodoCard todoCard = this.todoCardService.getCard(cardId);
        if (todoCard == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 데이터입니다.");
        }
        if (!todoCard.getTodoList().getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "권한이 없습니다.");
        }
        Long listId = todoCard.getTodoList().getId();
        this.scoreService.delete(todoCard.getScore());
        this.todoCardService.delete(todoCard);
        return "redirect:/todo_list/detail/" + listId;
    }

}
