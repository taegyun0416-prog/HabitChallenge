package org.example.sproutroutine.domain.board.presentation.controller;

import org.example.sproutroutine.domain.board.persistence.dto.status.StatusResponse;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.BadRequestException;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.NoContentsException;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.NotThingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OtherRoadController {
    @ExceptionHandler(BadRequestException.class) //잘못된 요청이 들어왔을때
    public ResponseEntity<StatusResponse> RequestError(BadRequestException e){
        StatusResponse statusResponse = new StatusResponse("Bad Request", e.getMessage());
        return new ResponseEntity<>(statusResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotThingException.class) //id로 객체를 찾을 수 없을때
    public ResponseEntity<StatusResponse> Anything(NotThingException e){
        StatusResponse statusResponse = new StatusResponse("Internal Server Error", e.getMessage());
        return new ResponseEntity<>(statusResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoContentsException.class) //전체 습관을 조회할때만 사용됨
    public ResponseEntity<StatusResponse> NoContent(NotThingException e){
        StatusResponse statusResponse = new StatusResponse("No Content", e.getMessage());
        return new ResponseEntity<>(statusResponse, HttpStatus.NO_CONTENT);
    }
}
