package org.example.sproutroutine.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor // 파라미터가 없는 생성자를 자동으로 생성해준다.
//JPA가 DB의 정보를 객체로 변환하게 하기 위해 필요함.
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID habit_id;

    //유저 기본키는 나중에 받아오기

    private String name;
    private boolean completed;
    private int streak;
    private int completedCount;
    private LocalDate lastCompletedDate;

    private String periodType; //넣을지 말지 고민... 그냥 분기로 받아서 Day나 Week에 갈 것 같은데...

    enum periodType {
        //만약에 periodType에서 고려하는 값이 더 늘어난다면 enum만 찾아서 변경하면 간단하다.
        DAY, WEEK
        //DAY와 WEEK에 각각 1, 2를 넣어서 사용자로부터 오는 정보가 1인지 2인지 인식하여 분기로 넘기면 된다?
        //굳이 이걸 저장해야하나? 그러니까, 사용자로부터 DAY나 WEEK가 오면 그때 DayOfWeek의 내용으로 넘기면... 아닌가? 표시는 해야하니까...
    }
    @Builder
    public Habit(String name, String periodType){
        this.name = name;
        this.periodType = periodType;
    }

    @ElementCollection //클래스는 아니나, 클래스 처럼 사용할 수 있도록 설명해주는? 어노테이션. 1:N관계에서 많이 사용함 (정확한 내요은 공부하기)
    @CollectionTable(name = "category", joinColumns = @JoinColumn(name = "habit_id"))
    //위의 어노테이션으로 설정한 테이블을 실제로 구현하기 위한 설명. 테이블의 이름, 상속(?)하는 테이블의 아이디를 알려준다.
    @Column(name = "categories")
    //데이터베이스의 categories에 매핑한다는 뜻으로, 아래 코드에서 바로 데이터베이스의 categories칼럼에 접근하기 위해 사용함.
    private ArrayList<String> category = new ArrayList<>(); //동적 할당을 해주는 ArrayList를 사용하여 많은 수를 저장할 수 있는 카테고리를 저장 할 수 있도록 한다.
}
