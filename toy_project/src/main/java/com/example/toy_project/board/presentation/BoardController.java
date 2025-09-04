package com.example.toy_project.board.presentation;

import com.example.toy_project.board.application.*;
import com.example.toy_project.board.domain.Board;
import com.example.toy_project.board.domain.BoardRepository;
import com.example.toy_project.board.presentation.request.CreateBoardRequest;
import com.example.toy_project.board.presentation.request.UpdateBoardRequest;
import com.example.toy_project.board.presentation.response.BoardResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final CreateBoardUseCase createBoardUseCase;
    private final UpdateBoardUserCase updateBoardUserCase;
    private final DeleteBoardUseCase deleteBoardUseCase;
    private final GetBoardUseCase getBoardUseCase;
    private final ListBoardUseCase listBoardUseCase;

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody CreateBoardRequest req) {
        Long id = createBoardUseCase.handle(req.getAuthorId(), req.getTitle(), req.getContent());
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateBoardRequest req) {
        updateBoardUserCase.handle(id, req.getEditorId(), req.getTitle(), req.getContent());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,
                                       @RequestParam Long requesterId) {
        deleteBoardUseCase.handle(id, requesterId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> detail(@PathVariable Long id) {
        Board b = getBoardUseCase.handle(id);
        return ResponseEntity.ok(BoardResponse.from(b));
    }

    @GetMapping
    public Page<BoardResponse> list(@RequestParam(required = false) String q,
                                    @PageableDefault(size=10, sort="id") Pageable pageable) {
        return listBoardUseCase.handle(q, pageable).map(BoardResponse::from);
    }
}
