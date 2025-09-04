package com.example.toy_project.board.application;

import com.example.toy_project.board.domain.Board;
import com.example.toy_project.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBoardUseCase {
    private final BoardRepository boardRepository;

    public Board handle(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시물이 존재하지 않습니다."));
    }
}