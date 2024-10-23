package com.todorank.hlw.domain.remembrance_comment.service;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import com.todorank.hlw.domain.remembrance_comment.entity.RemembranceComment;
import com.todorank.hlw.domain.remembrance_comment.repository.RemembranceCommentRepository;
import com.todorank.hlw.domain.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemembranceCommentService {
    private final RemembranceCommentRepository remembranceCommentRepository;

    public void create(Remembrance remembrance, SiteUser user, String content) {
        RemembranceComment comment = RemembranceComment.builder()
                .remembrance(remembrance)
                .user(user)
                .content(content)
                .build();
        this.remembranceCommentRepository.save(comment);
    }
}
