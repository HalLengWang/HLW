package com.todorank.hlw.domain.score.repository;

import com.todorank.hlw.domain.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
