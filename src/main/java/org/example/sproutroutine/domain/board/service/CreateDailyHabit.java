package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.DailyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.CreateException;
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
                .category(request.getCategory())
                .build();
        if(habit.getName().isBlank()){
            throw new CreateException("습관정보가 누락되었습니다.");
        }
        if (habit.getCategory().isEmpty()){
            throw new CreateException("습관정보가 누락되었습니다.");
        } else {
            for(int i=0; i< habit.getCategory().size(); i++){
                if(habit.getCategory().get(i).isBlank()){
                    throw new CreateException("습관정보가 누락되었습니다.");
                }
            }
        }
        habitRepository.save(habit);

        DailyHabit dalyHabit = DailyHabit.builder()
                .habit(habit)
                .totalRepeat(request.getTotalRepeat())
                .build();
        if (dalyHabit.getTotalRepeat() == 0){
            throw new CreateException("습관정보가 누락되었습니다.");
        }
        dayRepository.save(dalyHabit);

        return habit.getHabit_id();
    }
}
