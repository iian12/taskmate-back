package com.jygoh.taskmate.domain.schedule.repository;

import com.jygoh.taskmate.domain.schedule.model.Schedules;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

    List<Schedules> findByUserId(Long userId);

    List<Schedules> findByCategoryId(Long categoryId);

    List<Schedules> findByTitleContainingIgnoreCase(String title);
}
