package com.todorank.hlw.domain.score.sevice;


import com.todorank.hlw.domain.score.entity.Score;
import com.todorank.hlw.domain.score.repository.ScoreRepository;
import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.todo_card.repository.TodoCardRepository;
import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final TodoCardRepository todoCardRepository;

    @Transactional
    public void addScoreForCompletion(Long cardId, SiteUser user, TodoTypeList type) {
        TodoCard todoCard = todoCardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "할 일이 존재하지 않습니다."));

        Score existingScore = scoreRepository.findByUserIdAndTodoCardId(user.getId(), todoCard.getId());

        if (existingScore == null) {
            int pointsToAdd = 200;

            Score score = new Score();
            score.setUser(user);
            score.setScore(pointsToAdd);
            score.setTodoCard(todoCard);
            score.setSource(type.getTypeName());

            scoreRepository.save(score);
        } else {
            String newTypeName = type.getTypeName();
            if (!existingScore.getSource().equals(newTypeName)) {
                existingScore.setSource(newTypeName);
                scoreRepository.save(existingScore);
            }
        }
    }

    @Transactional
    public void addScoreForExecution(Long cardId, SiteUser user, Integer execution) {
        int pointsToAdd = execution * 2; // 1% 당 2점
        TodoCard todoCard = todoCardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "할 일이 존재하지 않습니다."));

        Score score = new Score();
        score.setUser(user);
        score.setScore(pointsToAdd);
        score.setTodoCard(todoCard);
        score.setSource("진행률 점수");

        scoreRepository.save(score);
    }


    @Transactional
    public void deleteScoreByTodoCardId(Long cardId) {
        scoreRepository.deleteByTodoCardId(cardId);
    }
}









