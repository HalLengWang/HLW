package com.todorank.hlw.domain.remembrance_comment.controller;

import com.todorank.hlw.domain.remembrance_comment.entity.RemembranceComment;
import com.todorank.hlw.domain.remembrance_comment.service.RemembranceCommentService;
import com.todorank.hlw.domain.todo_list.entity.TodoList;
import com.todorank.hlw.domain.todo_list.service.TodoListService;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/remembrance_comment")
public class RemembranceCommentController {
    private final RemembranceCommentService remembranceCommentService;
    private final TodoListService todoListService;
    private final UserService userService;

    @PostMapping("/create/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> createComment(@PathVariable("id") Long listId, Principal principal,
                                                @RequestBody Map<String, String> commentData) {
        TodoList todoList = this.todoListService.getTodoList(listId);
        if (todoList == null || todoList.getRemembrance() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 접근입니다.");
        }
        SiteUser user = this.userService.getUser(principal.getName());
        try {
            String content = commentData.get("content");
            this.remembranceCommentService.create(todoList.getRemembrance(), user, content);
            return ResponseEntity.ok("댓글이 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 저장에 실패했습니다.");
        }
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("isAuthenticated")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId, Principal principal) {
        RemembranceComment comment = this.remembranceCommentService.getComment(commentId);
        if (comment.getRemembrance() == null || comment.getRemembrance().getTodoList() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 접근입니다.");
        }
        TodoList todoList = comment.getRemembrance().getTodoList();
        if (!comment.getUser().getUsername().equals(principal.getName())
                && !todoList.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 접근입니다.");
        }
        try {
            this.remembranceCommentService.delete(comment);
            return ResponseEntity.ok("댓글이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 삭제에 실패했습니다.");
        }
    }
}
