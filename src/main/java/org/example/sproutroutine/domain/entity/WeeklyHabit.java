package org.example.sproutroutine.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class WeeklyHabit{
    @Id
    private Long weekId; //이 엔티티의 id가 없으면 MapsId로 연결하지 못하므로 있어야한다.

    @OneToOne(cascade = CascadeType.PERSIST) //Habit과 이 엔티티의 관계을 연결해주는 어노테이션. PERSIST는 부모가 Save되면 자식도 save되도록 해준다.
    @MapsId //FK값과 PK값을 연결해주는 어노테이션
    private Habit habit;

    //반복할 요일의 배열을 받고, 데이터베이스에 저장 후, 요일이 될때마다 인증을 하도록 버튼을 열어야 한다.
    //요일을 저장하고, 그 날의 요일이 무엇인지 확인하고 동작.
    @ElementCollection
    private List<Integer> weekOfDay = new ArrayList<>(); //요일을 저장하기 위해서 (배열의 크기가 7을 넘을 일이 없으니 일반 배열이 좋나?)

    @Builder
    public WeeklyHabit(Habit habit, List<Integer> weekOfDay){
        this.habit = habit;
        this.weekOfDay = weekOfDay;
    }
}
