package com.todorank.hlw.domain.remembrance.controller;

import com.todorank.hlw.domain.remembrance.service.RemembranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/remembrance")
public class RemembranceController {
    private final RemembranceService remembranceService;
}
