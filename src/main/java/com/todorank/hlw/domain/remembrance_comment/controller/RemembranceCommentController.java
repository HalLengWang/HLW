package com.todorank.hlw.domain.remembrance_comment.controller;

import com.todorank.hlw.domain.remembrance_comment.service.RemembranceCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/remembrance_comment")
public class RemembranceCommentController {
    private final RemembranceCommentService remembranceCommentService;
}
