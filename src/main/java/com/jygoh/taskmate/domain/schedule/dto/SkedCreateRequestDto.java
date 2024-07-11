package com.jygoh.taskmate.domain.schedule.dto;

import com.jygoh.taskmate.domain.schedule.model.Schedules;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SkedCreateRequestDto {

    private final String title;
    private final String description;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Long userId;
    private final Long categoryId;

    @Builder
    public SkedCreateRequestDto(String title, String description, LocalDateTime startTime,
        LocalDateTime endTime, Long userId, Long categoryId) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Schedules toEntity() {
        return Schedules.builder().title(this.title).description(this.description)
            .startTime(this.startTime).endTime(this.endTime).categoryId(this.categoryId)
            .userId(this.userId).build();
    }
}
