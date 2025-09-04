package com.example.toy_project.board.infrastructure;

import com.example.toy_project.board.domain.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "boards")
@Getter
@NoArgsConstructor
public class BoardJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long authorId;

    @Lob @Column(nullable = false)
    private String title;

    @Lob @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public BoardJpaEntity(Long id, Long authorId, String title, String content,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 도메인 -> JPA 엔티티 (저장할 때)
    public static BoardJpaEntity from(Board d) {
        return new BoardJpaEntity(
                d.getId(), d.getAuthorId(), d.getTitle(), d.getContent(), d.getCreatedAt(), d.getUpdatedAt()
        );
    }

    // JPA 엔티티 -> 도메인 (조회할 때)
    public Board toDomain() {
        return new Board(
                this.id, this.authorId, this.title, this.content, this.createdAt, this.updatedAt
        );
    }
}