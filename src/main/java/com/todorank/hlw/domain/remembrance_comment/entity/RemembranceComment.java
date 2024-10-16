package com.todorank.hlw.domain.remembrance_comment.entity;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RemembranceComment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "site_user_id")
    @NotNull
    private SiteUser user;

    @ManyToOne
    @JoinColumn(name = "remembrance_id")
    @NotNull
    private Remembrance remembrance;

    private String content;

    @ManyToMany
    private Set<SiteUser> votes;
}
