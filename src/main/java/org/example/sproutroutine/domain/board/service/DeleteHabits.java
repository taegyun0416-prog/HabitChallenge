package org.example.sproutroutine.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteHabits {
    private final HabitRepository habitRepository;

    public String Delete (Long id){
        habitRepository.deleteById(id);
        return "습관이 성공적으로 삭제되었습니다.";
    }
}
