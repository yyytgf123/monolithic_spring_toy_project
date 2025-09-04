package com.example.toy_project.board.presentation.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateBoardRequest {
    @NotNull
    private Long editorId;

    @NotBlank @Size(min = 1)
    private String title;

    @NotBlank
    private String content;
}