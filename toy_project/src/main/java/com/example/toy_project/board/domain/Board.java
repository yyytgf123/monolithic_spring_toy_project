package com.example.toy_project.board.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Objects;

public class Board {
    private final Long id;
    private final Long authorId;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Board(Long id, Long authorId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        validate(authorId, title, content);
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Board create(Long authorId, String title, String content) {
        LocalDateTime now = LocalDateTime.now();
        return new Board(null, authorId, title, content, now, null);
    }

    public Board edit(Long editorId, String newTitle, String newContent) {
        if (!Objects.equals(this.authorId, editorId)) {
            throw new IllegalArgumentException("작성자만 수정 가능");
        }
        return new Board(this.id, this.authorId, newTitle, newContent, this.createdAt, this.updatedAt);
    }

    private static void validate(Long authorId, String title, String content) {
        if (authorId == null) throw new IllegalArgumentException("authorId 필수");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("제목 필수");
        if (title.length() > 200) throw new IllegalArgumentException("제목은 200자 이내");
        if (content == null || content.isBlank()) throw new IllegalArgumentException("내용 필수");
    }

    public Long getId() { return id; }
    public Long getAuthorId() { return authorId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}