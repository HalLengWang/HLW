package com.todorank.hlw.domain.score.controller;

import com.todorank.hlw.domain.score.service.ScoreService;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.UserRepository;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/ranking/list")
    public String rankingListPage(Model model) {
        List<Map<String, Object>> rankedUsers = scoreService.getRankedUsers();
        model.addAttribute("rankedUsers", rankedUsers);
        return "rankings_list_page";
    }
}


