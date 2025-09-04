package com.example.toy_project.board.presentation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateBoardRequest {
    @NotNull
    private Long authorId;

    @NotBlank @Size(min = 1)
    private String title;

    @NotBlank @Size(min = 1)
    private String content;
}