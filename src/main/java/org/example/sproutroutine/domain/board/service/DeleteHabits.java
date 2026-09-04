package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteHabits {
    private final HabitRepository habitRepository;

    public void Delete (Long id){
        habitRepository.deleteById(id);
    }
}
