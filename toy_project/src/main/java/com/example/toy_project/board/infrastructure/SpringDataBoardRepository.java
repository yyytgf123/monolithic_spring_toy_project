package com.example.toy_project.board.infrastructure;

import com.example.toy_project.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// JpaRepository를 상속받아 save(), findById(), deleteById(), findAll()같은 CRUD 메소드 사용 가능
public interface SpringDataBoardRepository extends JpaRepository<BoardJpaEntity, Long> {
    Page<BoardJpaEntity> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
            String title, String content, Pageable pageable
    );
}