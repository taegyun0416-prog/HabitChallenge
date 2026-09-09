package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.response.GetAllHabitsResponse;
import org.example.sproutroutine.domain.board.persistence.dto.status.exceptions.NoContentsException;
import org.example.sproutroutine.domain.entity.Habit;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReadAllHabits {
    private final HabitRepository habitRepository;
    public List<GetAllHabitsResponse> ReadAll(){
        List<Habit> allHabitsResponseList = habitRepository.findAll();
        if (allHabitsResponseList.isEmpty()){
            throw new NoContentsException("조회할 습관이 없습니다.");
        }
        return allHabitsResponseList.stream().map(GetAllHabitsResponse::new).toList();
    }
}
