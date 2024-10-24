package com.todorank.hlw.domain.score.controller;


import com.todorank.hlw.domain.score.repository.ScoreRepository;
import com.todorank.hlw.domain.score.sevice.ScoreService;
import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.repository.TodoCardRepository;
import com.todorank.hlw.domain.todo_card.service.TodoCardService;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;
    private final UserRepository userRepository;
    private final TodoCardRepository todoCardRepository;

    @GetMapping("/score/add/{cardId}")
    public String addForScore(@PathVariable("cardId") Long cardId, Principal principal) {
        SiteUser currentUser = userRepository.findByusername(principal.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."));

        TodoCard todoCard = todoCardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "할 일이 존재하지 않습니다."));

        TodoTypeList type = todoCard.getTodoTypeList();
        Long listId = todoCard.getTodoList().getId();
        scoreService.addScoreForCompletion(cardId, currentUser, type);

        return "redirect:/todo_list/detail/" + listId;
    }

    @GetMapping("/score/add/execution/{cardId}")
    public String addExecutionScore(@PathVariable("cardId") Long cardId,
                                    @RequestParam("execution") Integer execution,
                                    Principal principal) {
        SiteUser currentUser = userRepository.findByusername(principal.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."));

        scoreService.addScoreForExecution(cardId, currentUser, execution);

        return "redirect:/todo_list/detail/" + cardId;
    }

    @GetMapping("/score/delete/{cardId}")
    public String deleteScore(@PathVariable("cardId") Long cardId) {
        TodoCard todoCard = todoCardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "할 일이 존재하지 않습니다."));
        Long listId = todoCard.getTodoList().getId();
        scoreService.deleteScoreByTodoCardId(cardId);
        return "redirect:/todo_list/detail/" + listId;
    }
}















