package org.example.sproutroutine.domain.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class DailyHabit extends Habit{
    @Builder
    public DailyHabit(String name, String periodType, int totalRepeat){
        super(name, periodType); //부모클래스에 String매개변수를 2개 받는 생성자를 불러온다. 즉, 두개를 따로 불러들이면 안됨
        this.totalRepeat = totalRepeat;
    }
    @Override
    public long getHabit_id() {
        return super.getHabit_id();
    }
    private int totalRepeat;
    public void habitUpdate_day(int totalRepeat){
        this.totalRepeat = totalRepeat;
    }
}