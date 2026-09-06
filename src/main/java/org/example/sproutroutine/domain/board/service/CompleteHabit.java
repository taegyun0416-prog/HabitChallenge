package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.HabitCompleteRequest;
import org.example.sproutroutine.domain.board.persistence.dto.response.CompleteError;
import org.example.sproutroutine.domain.entity.DailyHabit;
import org.example.sproutroutine.domain.entity.Habit;
import org.example.sproutroutine.domain.repository.DayRepository;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompleteHabit {
    private final HabitRepository habitRepository;
    private final DayRepository dayRepository;
    public Long Complete(Long id, HabitCompleteRequest request){
        Habit habit = habitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("인증할 습관이 없습니다."));
        if(habit.getPeriodType().equals("WEEKLY")){
            if(request.getCompletedCount() >= 1){
                habit.CompleteUpdate(request.getCompletedCount(), true);
            }
        } else {
            DailyHabit dailyHabit = dayRepository.findById(id).orElseThrow(()->new IllegalArgumentException("하루기준 습관이 생성되어있지 않습니다."));
            if(request.getCompletedCount() == dailyHabit.getTotalRepeat()){
                habit.CompleteUpdate(request.getCompletedCount(), true);
            } else if(request.getCompletedCount() > dailyHabit.getTotalRepeat()){
                throw new IllegalArgumentException("인증요청이 잘못되었습니다.");
            } else {
                habit.CompleteUpdate(request.getCompletedCount(), false);
            }
        }
        return id;
    }
}
