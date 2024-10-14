package com.todorank.hlw.domain.todo_card.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoCardForm {
    @NotEmpty(message = "제목을 입력해 주세요.")
    private String title;

    private String memo;

    @NotEmpty(message = "시작일을 정해주세요")
    private LocalDateTime startDateTime;

    @NotEmpty(message = "마감일을 정해주세요")
    private LocalDateTime endDateTime;
    
    private Boolean completion;

    private Integer execution;
}
