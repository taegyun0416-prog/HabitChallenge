package org.example.sproutroutine.domain.repository;

import org.example.sproutroutine.domain.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
}
