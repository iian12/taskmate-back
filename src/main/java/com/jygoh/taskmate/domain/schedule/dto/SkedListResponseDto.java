package com.jygoh.taskmate.domain.schedule.dto;

import com.jygoh.taskmate.domain.schedule.model.Schedules;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SkedListResponseDto {

    private final Long id;
    private final String title;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Long userId;
    private final Long categoryId;

    @Builder
    public SkedListResponseDto(Long id, String title, LocalDateTime startTime,
        LocalDateTime endTime, Long userId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public static SkedListResponseDto fromEntity(Schedules schedules) {
        return SkedListResponseDto.builder().id(schedules.getId()).title(schedules.getTitle())
            .startTime(schedules.getStartTime()).endTime(schedules.getEndTime())
            .userId(schedules.getUserId()).categoryId(schedules.getCategoryId()).build();
    }

    public static List<SkedListResponseDto> fromEntityList(List<Schedules> schedules) {
        return schedules.stream().map(SkedListResponseDto::fromEntity).collect(Collectors.toList());
    }
}
