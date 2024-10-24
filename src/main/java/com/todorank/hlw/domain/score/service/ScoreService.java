package com.todorank.hlw.domain.score.service;

import com.todorank.hlw.domain.score.entity.Score;
import com.todorank.hlw.domain.score.repository.ScoreRepository;
import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.user.entity.SiteUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    @Transactional
    public void create(TodoCard todoCard, SiteUser user) {
        Integer scoreValue = 0;
        if (todoCard.getCompletion()) {
            scoreValue = todoCard.getExecution() * todoCard.getTodoTypeList().getRatio();
        }
        Score score = Score.builder()
                .score(scoreValue)
                .todoCard(todoCard)
                .user(user)
                .build();
        this.scoreRepository.save(score);
    }

    @Transactional
    public void modify(TodoCard todoCard) {
        Integer scoreValue = 0;
        if (todoCard.getCompletion()) {
            scoreValue = todoCard.getExecution() * todoCard.getTodoTypeList().getRatio();
        }

        Score score = todoCard.getScore().toBuilder()
                .score(scoreValue)
                .build();
        this.scoreRepository.save(score);
    }

    @Transactional
    public void delete(Score score) {
        this.scoreRepository.delete(score);
    }
}
