package org.example.sproutroutine.domain.board.persistence.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class StatusResponse{
    private String status;
    private String message;
}
