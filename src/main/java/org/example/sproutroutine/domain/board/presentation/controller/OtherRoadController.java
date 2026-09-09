package org.example.sproutroutine.domain.board.presentation.controller;

import org.example.sproutroutine.domain.board.persistence.dto.status.StatusResponse;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.CreateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OtherRoadController {
    @ExceptionHandler(CreateException.class)
    public ResponseEntity<StatusResponse> RequestError(CreateException e){
        StatusResponse statusResponse = new StatusResponse("Bad Request", e.getMessage());
        return new ResponseEntity<>(statusResponse, HttpStatus.BAD_REQUEST);
    }
}
