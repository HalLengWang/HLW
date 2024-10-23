package com.todorank.hlw.domain.remembrance_comment.repository;

import com.todorank.hlw.domain.remembrance_comment.entity.RemembranceComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemembranceCommentRepository extends JpaRepository<RemembranceComment, Long> {
}
