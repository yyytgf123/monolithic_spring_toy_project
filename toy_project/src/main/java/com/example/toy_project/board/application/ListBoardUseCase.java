package com.example.toy_project.board.application;

import com.example.toy_project.board.domain.Board;
import com.example.toy_project.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListBoardUseCase {
    private final BoardRepository boardRepository;

    public Page<Board> handle(String keyword, Pageable pageable) {
        return boardRepository.search(keyword, pageable);
    }
}