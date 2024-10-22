package com.todorank.hlw.domain.remembrance.service;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import com.todorank.hlw.domain.remembrance.form.RemembranceForm;
import com.todorank.hlw.domain.remembrance.repository.RemembranceRepository;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemembranceService {
    private final RemembranceRepository remembranceRepository;

    public void create (RemembranceForm remembranceForm, TodoList todoList) {
        Remembrance remembrance = Remembrance.builder()
                .title(remembranceForm.getTitle())
                .content(remembranceForm.getContent())
                .isPublic(remembranceForm.getIsPublic())
                .todoList(todoList)
                .build();
        this.remembranceRepository.save(remembrance);
    }

    public void modify (RemembranceForm remembranceForm, Remembrance remembrance) {
        Remembrance modified = remembrance.toBuilder()
                .title(remembranceForm.getTitle())
                .content(remembranceForm.getContent())
                .isPublic(remembranceForm.getIsPublic())
                .build();
        this.remembranceRepository.save(modified);
    }

    public void delete (Remembrance remembrance) {
        this.remembranceRepository.delete(remembrance);
    }
}
