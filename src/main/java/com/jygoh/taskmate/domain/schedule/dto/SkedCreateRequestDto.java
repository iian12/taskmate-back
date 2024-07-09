package com.jygoh.taskmate.domain.schedule.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SkedCreateRequestDto {

    private String title;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
