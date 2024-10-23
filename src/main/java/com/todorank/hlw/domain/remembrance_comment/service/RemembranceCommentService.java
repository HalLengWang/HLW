package com.todorank.hlw.domain.remembrance_comment.service;

import com.todorank.hlw.domain.remembrance_comment.repository.RemembranceCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemembranceCommentService {
    private final RemembranceCommentRepository remembranceCommentRepository;
}
