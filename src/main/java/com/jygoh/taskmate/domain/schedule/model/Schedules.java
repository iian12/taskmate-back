package com.jygoh.taskmate.domain.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Schedules {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private String title;

    private String description;

    private Long categoryId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Builder
    public Schedules(String userId, String title, String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
