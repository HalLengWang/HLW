package com.todorank.hlw.domain.remembrance_comment.entity;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RemembranceComment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id")
    //TODO erd 수정이 필요함
    private SiteUser user;

    private Remembrance remembrance;

    private String content;

    @ManyToMany
    private Set<SiteUser> votes;
}
