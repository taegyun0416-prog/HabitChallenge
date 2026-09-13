//package org.example.sproutroutine.domain.board.service.count;
//
//import lombok.RequiredArgsConstructor;
//import org.example.sproutroutine.domain.entity.Habit;
//import org.example.sproutroutine.domain.repository.HabitRepository;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CountTime {
//    private HabitRepository habitRepository;
//
//    //아래의 구조를 사용하지 않고 특정특정 요일에 인증하는 습관들의 아이디를 저장하고, 그 아이디만 completed를 false로 바꿔서 인증할 수 있도록 한다.]
//    // (그리고 그 요일이 아니면 true로 바꾼다. 이때 true로 바꾸지만 스트릭에 영향이 가지는 않는다.)
//
//    //근데 이렇게 된다면 습관을 삭제할때 저장한 리스트를 다 돌면서 검사 해야한다.
//
//    //그리고 수정해야하는 코드가 너무 많아진다. 습관 수정이나 생성할때 저장해야 하는 부분이 너무 많아진다.
//
//
//    //============================================================
//    //아래 구조를 사용한다면 습관을 불러오고 DayOfWeek에 저장된 숫자가 일치하는지 확인하고 맞다면 completed를 바꾼다.
//
//    //위 설계대로 하기 위해선 현재 요일을 받아오는 방법을 공부하고, for문과 if문이 반복적으로 사용될 수 있음.
//
//    //============================================================하루가 지나면 동작
//    @Scheduled(cron = "0 0 0 * * *")
//    public void Day(){
//        //0시가 되면 모든 습관을 가져와서 completed의 상태가true인지 확인해야한다.
//        //만약 true가 아닌 습관이 있다면 전체 스트릭을 초기화 한다.
//        //전부 true라면 전체 스트릭에 +1을 한다.
//        int size =  habitRepository.findAll().size();
//        for(long i = 0; i < size; i++){
//            Habit habit = habitRepository.findById(i).orElseThrow(()->new RuntimeException("삭제되었나 봅니다..."));
//            if (!habit.isCompleted()) { //조건문에 전체 스트릭이 0인지 판단하는 코드도 추가하기
//                // (이렇게 하면 if문을 여러번 돌지 않아도 될듯. 스트릭이 0이라면 안쪽에 스트릭 초기화를 안해도 된다.)
//                //유저 엔티티에 저장된 AllStreak초기화하기 - 나중에 머지하고 코드 추가하기
//
//
//            }
//        }
//        //=========================================================해당 요일이 일주일 인증 요일이 맞는지 확인하는 코드
//        for(long i = 0; i < size; i++){
//            Habit habit = habitRepository.findById(i).orElseThrow(()->new RuntimeException("삭제되었나 봅니다..."));
//            if (habit.getPeriodType().equals("WEEKLY")){
//                for(int j = 0; j< habit.getWeeklyHabit().getWeekOfDay().size(); j++){
//                    if(habit.getWeeklyHabit().getWeekOfDay().get(j).equals()){ //현재 요일과 같은지 판단하고 분기문 실행
//
//                    }
//                }
//            }
//        }
//    }
//}
