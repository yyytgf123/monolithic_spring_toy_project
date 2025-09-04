package com.example.toy_project.board.presentation.response;

import com.example.toy_project.board.domain.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResponse {
    private Long id;
    private Long authorId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardResponse from(Board b) {
        return BoardResponse.builder()
                .id(b.getId())
                .authorId(b.getAuthorId())
                .title(b.getTitle())
                .content(b.getContent())
                .createdAt(b.getCreatedAt())
                .updatedAt(b.getUpdatedAt())
                .build();
    }
}