package org.example.sproutroutine.domain.board.persistence.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DalyHabitCreatRequest {
    private String habitName;
    private String periodType;
    private String category;
    private int totalRepeat;
}
