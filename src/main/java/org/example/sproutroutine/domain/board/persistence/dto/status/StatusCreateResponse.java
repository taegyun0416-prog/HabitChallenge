package org.example.sproutroutine.domain.board.persistence.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StatusCreateResponse {
    private String status;
    private String message;
    private Long id;
}
