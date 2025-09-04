package com.example.toy_project.board.infrastructure;

import com.example.toy_project.board.domain.Board;
import com.example.toy_project.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BoardRepositoryAdapter implements BoardRepository {

    private final SpringDataBoardRepository repo;

    @Override
    @Transactional
    public Board save(Board board) {
        BoardJpaEntity saved = repo.save(BoardJpaEntity.from(board));
        // CreateBoardUseCase에서 getId를 사용하기 위해 도메인 return
        return saved.toDomain();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return repo.findById(id).map(BoardJpaEntity::toDomain);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Board> search(String keyword, Pageable pageable) {
        String k = (keyword == null) ? "" : keyword;
        return repo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(k, k, pageable)
                .map(BoardJpaEntity::toDomain);
    }
}