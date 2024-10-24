package com.todorank.hlw.domain.remembrance.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemembranceForm {
    @NotEmpty(message = "제목을 입력해 주세요.")
    private String title;

    @NotEmpty(message = "내용을 입력해 주세요.")
    private String content;

    private Boolean isPublic;
}
