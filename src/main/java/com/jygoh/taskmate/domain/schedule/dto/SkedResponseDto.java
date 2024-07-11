package com.jygoh.taskmate.domain.schedule.dto;

import com.jygoh.taskmate.domain.schedule.model.Schedules;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SkedResponseDto {

    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Long userId;
    private final Long categoryId;

    @Builder
    public SkedResponseDto(Long id, String title, String description, LocalDateTime startTime,
        LocalDateTime endTime, Long userId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public static SkedResponseDto fromEntity(Schedules schedules) {
        return SkedResponseDto.builder().id(schedules.getId()).title(schedules.getTitle())
            .description(schedules.getDescription()).startTime(schedules.getStartTime())
            .endTime(schedules.getEndTime()).userId(schedules.getUserId())
            .categoryId(schedules.getCategoryId()).build();
    }

}
