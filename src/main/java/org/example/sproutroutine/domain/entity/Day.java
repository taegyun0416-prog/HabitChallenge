package org.example.sproutroutine.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Day extends Habit{
    @Override
    public UUID getHabit_id() {
        return super.getHabit_id();
    }
    private int totalRepeat;
}
