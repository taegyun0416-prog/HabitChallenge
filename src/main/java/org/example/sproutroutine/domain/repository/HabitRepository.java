package org.example.sproutroutine.domain.repository;

import org.example.sproutroutine.domain.entity.Habit;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    @Override
    @EntityGraph(attributePaths = {"dailyHabit", "weeklyHabit", "category"})
    @NullMarked
    List<Habit> findAll();
}
