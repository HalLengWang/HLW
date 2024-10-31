package com.todorank.hlw.domain.todo_card.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Getter
@Setter
public class TodoCardForm {
    @NotNull(message = "카테고리를 선택해야 합니다.")
    private Long category;

    @NotEmpty(message = "제목을 입력해 주세요.")
    private String title;

    private String memo;

    @NotNull(message = "시작시간을 정해주세요")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @NotNull(message = "마감시간을 정해주세요")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    private Boolean completion;

    private Integer execution;
}
