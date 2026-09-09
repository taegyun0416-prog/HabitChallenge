package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.WeeklyHabitCreatRequest;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.BadRequestException;
import org.example.sproutroutine.domain.entity.Habit;
import org.example.sproutroutine.domain.entity.WeeklyHabit;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.example.sproutroutine.domain.repository.WeekRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //final속성들에게 생성자 만들어주는 어노테이션
public class CreateWeeklyHabit {
    private final WeekRepository weekRepository;
    private final HabitRepository habitRepository;

    @Transactional
    public String weeklyCreate(WeeklyHabitCreatRequest request){
        if(request.getHabitName().isBlank()){
            throw new BadRequestException("습관정보가 누락되었습니다."); //DailyHabit에서도 반복되니 따로 빼서 사용하는게 좋나...?
        }
        for(int i=0; i< request.getCategory().size(); i++){
            if(request.getCategory().get(i).isBlank()){
                throw new BadRequestException("습관정보가 누락되었습니다.");
            }
        }
        Habit habit = Habit.builder()
                .name(request.getHabitName())
                .periodType(request.getPeriodType())
                .category(request.getCategory())
                .build();
        habitRepository.save(habit);

        WeeklyHabit weeklyHabit = WeeklyHabit.builder()
                .habit(habit)
                .weekOfDay(request.getWeekOfDay())
                .build();
        weekRepository.save(weeklyHabit);
        weeklyHabit.CreateWeekCount(); //인증할 요일을 선택한 배열을 받아서 배열의 크기를 저장하는 메서드(스트릭을 계산할 때 사용하기 위해서)

        return "습관이 성공적으로 생성되었습니다.";
    }
}
