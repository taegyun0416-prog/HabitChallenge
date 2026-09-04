package org.example.sproutroutine.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class DailyHabit{
    @Id
    private Long dayId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    private Habit habit;

    @Builder
    public DailyHabit(Habit habit, int totalRepeat){
        this.habit = habit;
        this.totalRepeat = totalRepeat;
    }

    private int totalRepeat;
    public void habitUpdate_day(int totalRepeat){
        this.totalRepeat = totalRepeat;
    }
}