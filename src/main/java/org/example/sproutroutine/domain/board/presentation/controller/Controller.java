package org.example.sproutroutine.domain.board.presentation.controller;
import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.DailyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.HabitCompleteRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.HabitsPatchRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.response.GetAllHabitsResponse;
import org.example.sproutroutine.domain.board.persistence.dto.status.StatusCreateResponse;
import org.example.sproutroutine.domain.board.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor //필수 인자를 가진 생성자를 자동으로 생성 (이게 있기 때문에 밑에 서비스 클래스들을 불러올 수 있는 것.
public class Controller {
    private final CreateDailyHabit createDailyHabit;
    private final CreateWeeklyHabit createWeeklyHabit;
    private final DeleteHabits deleteHabits;
    private final CompleteHabit completeHabit;
    private final ReadAllHabits readAllHabits;
    private final HabitsPatch habitsPatch;

    @PostMapping("/habit/day")
    public ResponseEntity<StatusCreateResponse> postDailyHabit(@RequestBody DailyHabitCreatRequest request){
        StatusCreateResponse statusCreateResponse = new StatusCreateResponse(
                "OK",
                "습관이 성공적으로 생성되었습니다.",
                createDailyHabit.dalyCreate(request));
        return new ResponseEntity<>(statusCreateResponse, HttpStatus.CREATED);
    }

    @PostMapping("/habit/week")
    public ResponseEntity<StatusCreateResponse> postWeeklyHabit(@RequestBody WeeklyHabitCreatRequest request){
        StatusCreateResponse statusCreateResponse = new StatusCreateResponse(
                "OK",
                "습관이 성공적으로 생성되었습니다.",
                createWeeklyHabit.weeklyCreate(request));
        return new ResponseEntity<>(statusCreateResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/habit/{id}")
    public void deleteHabit(@PathVariable Long id){
        //@PathVariabl은 경로에서 받은 Id값을 받아오는 어노테이션
        deleteHabits.Delete(id);
    }

    @PatchMapping("/habit/{id}")
    public Long completeHabit(@PathVariable Long id, @RequestBody HabitCompleteRequest request){
        return completeHabit.Complete(id, request);
    }

    @GetMapping("/habit")
    public List<GetAllHabitsResponse> getAllHabit (){
        return readAllHabits.ReadAll();
    }

    @PatchMapping("/habit/update/{id}")
    public void patchHabits (@PathVariable Long id, @RequestBody HabitsPatchRequest request){
        habitsPatch.Patch(id, request);
    }
}
