package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.CreateException;
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
                .category(request.getCategory())
                .build();
        if(habit.getName().isBlank()){
            throw new CreateException("습관정보가 누락되었습니다."); //DailyHabit에서도 반복되니 따로 빼서 사용하는게 좋나...?
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

        WeeklyHabit weeklyHabit = WeeklyHabit.builder()
                .habit(habit)
                .weekOfDay(request.getWeekOfDay())
                .build();
        weekRepository.save(weeklyHabit);
        weeklyHabit.CreateWeekCount(); //인증할 요일을 선택한 배열을 받아서 배열의 크기를 저장하는 메서드(스트릭을 계산할 때 사용하기 위해서)

        return habit.getHabit_id();
    }
}
