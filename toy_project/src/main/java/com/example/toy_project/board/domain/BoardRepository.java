package com.example.toy_project.board.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

// 기능 정의 - 동작 구현 필요
public interface BoardRepository {
    Board save(Board board);
    Optional<Board> findById(Long id);
    void deleteById(Long id);
    Page<Board> search(String keyword, Pageable pageable);
}