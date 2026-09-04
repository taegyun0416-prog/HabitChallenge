package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.entity.Habit;
import org.example.sproutroutine.domain.entity.WeeklyHabit;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.example.sproutroutine.domain.repository.WeekRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor //final속성들에게 생성자 만들어주는 어노테이션
public class CreateWeeklyHabit {
    private final WeekRepository weekRepository;
    private final HabitRepository habitRepository;

    @Transactional
    public Long weeklyCreate(WeeklyHabitCreatRequest request){
        Habit habit = Habit.builder()
                .name(request.getHabitName())
                .periodType(request.getPeriodType())
                .build();
        habitRepository.save(habit);

        WeeklyHabit weeklyHabit = WeeklyHabit.builder()
                .habit(habit)
                .weekOfDay(request.getWeekOfDay())
                .build();
        weekRepository.save(weeklyHabit);

        return habit.getHabit_id();
    }
}
