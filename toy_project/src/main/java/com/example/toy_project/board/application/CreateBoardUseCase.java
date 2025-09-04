package com.example.toy_project.board.application;

import com.example.toy_project.board.domain.Board;
import com.example.toy_project.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateBoardUseCase {
    private final BoardRepository boardRepository;

    @Transactional
    public Long handle(Long authorId, String title, String content) {
        Board created = Board.create(authorId, title, content);
        return boardRepository.save(created).getId();
    }
}