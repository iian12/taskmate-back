package com.jygoh.taskmate.domain.schedule.repository;

import com.jygoh.taskmate.domain.schedule.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
}
