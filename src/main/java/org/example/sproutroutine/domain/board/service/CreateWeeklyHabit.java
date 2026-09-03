package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.entity.WeeklyHabit;
import org.example.sproutroutine.domain.repository.WeekRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor //final속성들에게 생성자 만들어주는 어노테이션
public class CreateWeeklyHabit {
    private final WeekRepository weekRepository;

    @Transactional
    public long weeklyCreate(WeeklyHabitCreatRequest request){
        WeeklyHabit weeklyHabit = WeeklyHabit.builder()
                .name(request.getHabitName())
                .periodType(request.getPeriodType())
                .weekOfDay(request.getWeekOfDay())
                .build();
        return weekRepository.save(weeklyHabit).getHabit_id();
    }
}
