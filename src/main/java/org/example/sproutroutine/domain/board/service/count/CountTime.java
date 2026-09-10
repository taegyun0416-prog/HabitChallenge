package org.example.sproutroutine.domain.board.service.count;

import lombok.RequiredArgsConstructor;
import org.example.sproutroutine.domain.entity.Habit;
import org.example.sproutroutine.domain.repository.HabitRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountTime {
    private HabitRepository habitRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void Day(){
        //0시가 되면 모든 습관을 가져와서 completed의 상태가true인지 확인해야한다.
        //만약 true가 아닌 습관이 있다면 전체 스트릭을 초기화 한다.
        //전부 true라면 전체 스트릭에 +1을 한다.
        int size =  habitRepository.findAll().size();
        for(long i = 0; i < size; i++){
            Habit habit = habitRepository.findById(i).orElseThrow(()->new RuntimeException("삭제되었나 봅니다..."));
            if (!habit.isCompleted()){
                //유저 엔티티에 저장된 AllStreak초기화하기 - 나중에 머지하고 코드 추가하기
                //아직 코드를 어떻게 짜야할지 알아보고 있는 중이라 부족한 부분이 많다...
            }
        }
    }
}
