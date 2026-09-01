package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.request.DalyHabitCreatRequest;
import org.example.sproutroutine.domain.entity.DalyHabit;
import org.example.sproutroutine.domain.repository.DayRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor //final인 속성에 전부 생성자를 생성해준다.
public class CreateDalyHabit {
    private final DayRepository dayRepository;

    @Transactional
    public UUID dalyCreat(DalyHabitCreatRequest request){
        DalyHabit dalyHabit = DalyHabit.builder()
                .name(request.getHabitName())
                .periodType(request.getPeriodType())
                .totalRepeat(request.getTotalRepeat())
                .build();
        return dayRepository.save(dalyHabit).getHabit_id(); //save()안에 객체의 이름을 넣어야함
    }
}
