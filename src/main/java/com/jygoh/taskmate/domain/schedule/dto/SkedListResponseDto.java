package com.jygoh.taskmate.domain.schedule.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SkedListResponseDto {

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
