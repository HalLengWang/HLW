package com.todorank.hlw.domain.score.repository;

import com.todorank.hlw.domain.score.entity.Score;
import com.todorank.hlw.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ScoreRepository extends JpaRepository<Score,Long> {
    Score findByUserIdAndTodoCardId(Long userId, Long todoCardId);
    void deleteByTodoCardId(Long todoCardId);
}
