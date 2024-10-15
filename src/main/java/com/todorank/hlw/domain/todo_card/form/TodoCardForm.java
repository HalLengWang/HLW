package com.todorank.hlw.domain.todo_card.form;

import com.todorank.hlw.domain.todo_type_list.entity.TodoTypeList;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoCardForm {
    @NotNull(message = "카테고리를 선택해야 합니다.")
    private Long category;

    @NotEmpty(message = "제목을 입력해 주세요.")
    private String title;

    private String memo;

    @NotNull(message = "시작일을 정해주세요")
    private LocalDateTime startDateTime;

    @NotNull(message = "마감일을 정해주세요")
    private LocalDateTime endDateTime;

    private Boolean completion;

    private Integer execution;
}
