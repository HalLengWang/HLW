package com.todorank.hlw.domain.score.service;

import com.todorank.hlw.domain.score.entity.Score;
import com.todorank.hlw.domain.score.repository.ScoreRepository;
import com.todorank.hlw.domain.todo_card.entity.TodoCard;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository; // UserRepository 추가

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

    @Transactional
    public Integer calculateTotalScore(SiteUser user) {
        List<Score> scores = scoreRepository.findByUser(user);
        return scores.stream()
                .mapToInt(Score::getScore)
                .sum();
    }

    @Transactional
    public List<Map<String, Object>> getRankedUsers() {
        List<SiteUser> users = userRepository.findAll(); // 모든 사용자 가져오기
        List<Map<String, Object>> rankedUsers = new ArrayList<>();

        for (SiteUser user : users) {
            Integer totalScore = calculateTotalScore(user); // 각 사용자의 점수 합산
            Map<String, Object> userScore = new HashMap<>();
            userScore.put("nickname", user.getNickname());
            userScore.put("totalScore", totalScore);
            rankedUsers.add(userScore);
        }

        // 점수로 정렬 (내림차순)
        rankedUsers.sort((a, b) -> Integer.compare((Integer) b.get("totalScore"), (Integer) a.get("totalScore")));
        return rankedUsers;
    }
}

