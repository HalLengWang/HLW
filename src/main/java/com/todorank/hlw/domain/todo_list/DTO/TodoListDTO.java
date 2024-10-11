package com.todorank.hlw.domain.todo_list.DTO;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TodoListDTO {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String title;
    private Remembrance remembrance;
    private Long userId;  // 민감한 정보는 제외하고 ID만 전달
    private String username;
}
