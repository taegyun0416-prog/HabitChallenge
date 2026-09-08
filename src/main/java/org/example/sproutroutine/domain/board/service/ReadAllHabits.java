package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.board.persistence.dto.response.GetAllHabitsResponse;
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
        return allHabitsResponseList.stream().map(GetAllHabitsResponse::new).toList();
    }
}
