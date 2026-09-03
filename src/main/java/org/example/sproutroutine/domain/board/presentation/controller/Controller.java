package org.example.sproutroutine.domain.board.presentation.controller;
import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.DailyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.board.service.CreateDailyHabit;
import org.example.sproutroutine.domain.board.service.CreateWeeklyHabit;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
    private final CreateDailyHabit createDailyHabit;
    private final CreateWeeklyHabit createWeeklyHabit;

    @PostMapping("/habit/day")
    public long postDailyHabit(@RequestBody DailyHabitCreatRequest request){
        return createDailyHabit.dalyCreate(request);
    }

    @PostMapping("/habit/week")
    public long postWeeklyHabit(@RequestBody WeeklyHabitCreatRequest request){
        return createWeeklyHabit.weeklyCreate(request);
    }
}
