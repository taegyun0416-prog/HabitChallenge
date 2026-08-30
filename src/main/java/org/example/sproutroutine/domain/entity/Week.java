package org.example.sproutroutine.domain.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Week extends Habit{
    @Override
    public UUID getHabit_id() {
        return super.getHabit_id();
    }
    //반복할 요일의 배열을 받고, 데이터베이스에 저장 후, 요일이 될때마다 인증을 하도록 버튼을 열어야 한다.
    //요일을 저장하고, 그 날의 요일이 무엇인지 확인하고 동작.
    private ArrayList<Integer> weekOfDay = new ArrayList<>(); //요일을 저장하기 위해서 (배열의 크기가 7을 넘을 일이 없으니 일반 배열이 좋나?)
}
