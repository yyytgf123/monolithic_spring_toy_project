package com.example.toy_project.board.application;

import com.example.toy_project.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteBoardUseCase {
    private final BoardRepository boardRepository;

    @Transactional
    public void handle(Long boardId, Long requesterId) {
        boardRepository.deleteById(boardId);
    }
}