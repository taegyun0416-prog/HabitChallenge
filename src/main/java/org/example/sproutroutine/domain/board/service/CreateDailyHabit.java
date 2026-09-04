package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.DailyHabitCreatRequest;
import org.example.sproutroutine.domain.entity.DailyHabit;
import org.example.sproutroutine.domain.entity.Habit;
import org.example.sproutroutine.domain.repository.DayRepository;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //final인 속성에 전부 생성자를 생성해준다.
public class CreateDailyHabit {
    private final DayRepository dayRepository;
    private final HabitRepository habitRepository;

    @Transactional
    public Long dalyCreate(DailyHabitCreatRequest request){
        Habit habit = Habit.builder()
                .name(request.getHabitName())
                .periodType(request.getPeriodType())
                .build();
        habitRepository.save(habit);

        DailyHabit dalyHabit = DailyHabit.builder()
                .habit(habit)
                .totalRepeat(request.getTotalRepeat())
                .build();
        dayRepository.save(dalyHabit);

        return habit.getHabit_id();
    }
}
