package com.example.toy_project.board.application;

import com.example.toy_project.board.domain.Board;
import com.example.toy_project.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateBoardUserCase {
    private final BoardRepository boardRepository;

    @Transactional
    public void handle(Long boardId, Long editorId, String title, String content) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시물이 존재하지 않습니다"));
        Board edited = board.edit(editorId, title, content);
        boardRepository.save(edited);
    }
}