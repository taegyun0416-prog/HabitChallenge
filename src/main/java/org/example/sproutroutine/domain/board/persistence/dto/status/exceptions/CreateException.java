package org.example.sproutroutine.domain.board.persistence.dto.status.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateException extends RuntimeException{
    public CreateException (String message){
        super(message);
    }
}
