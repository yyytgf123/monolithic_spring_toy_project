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
        // BoardRepositoryAdapter에서 return 받아 Board Controller에
        // 응답을 주기 위해 getId() return해줌
        // 클라이언트에게 새로 생성된 게시글 주소를 바로 접근 가능하게 해주기 위함
        // EX) /api/boards/123, id : 123
        return boardRepository.save(created).getId();
    }
}