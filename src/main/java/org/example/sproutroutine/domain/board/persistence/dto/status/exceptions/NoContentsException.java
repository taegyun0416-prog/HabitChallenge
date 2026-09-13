package org.example.sproutroutine.domain.board.persistence.dto.status.exceptions;

public class NoContentsException extends RuntimeException {
    public NoContentsException(String message) {
        super(message);
    }
}
