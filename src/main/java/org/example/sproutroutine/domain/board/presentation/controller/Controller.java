package org.example.sproutroutine.domain.board.presentation.controller;
import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.DailyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.HabitCompleteRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.HabitsPatchRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.response.GetAllHabitsResponse;
import org.example.sproutroutine.domain.board.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
    private final CreateDailyHabit createDailyHabit;
    private final CreateWeeklyHabit createWeeklyHabit;
    private final DeleteHabits deleteHabits;
    private final CompleteHabit completeHabit;
    private final ReadAllHabits readAllHabits;
    private final HabitsPatch habitsPatch;

    @PostMapping("/habit/day")
    public long postDailyHabit(@RequestBody DailyHabitCreatRequest request){
        return createDailyHabit.dalyCreate(request);
    }

    @PostMapping("/habit/week")
    public long postWeeklyHabit(@RequestBody WeeklyHabitCreatRequest request){
        return createWeeklyHabit.weeklyCreate(request);
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
    public void patchHabits (@PathVariable Long id, @RequestBody HabitsPatchRequest request, SessionStatus sessionStatus){
        habitsPatch.Patch(id, request);

    }
}
