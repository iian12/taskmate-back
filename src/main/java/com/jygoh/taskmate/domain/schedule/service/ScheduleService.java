package com.jygoh.taskmate.domain.schedule.service;

import com.jygoh.taskmate.domain.schedule.dto.SkedCreateRequestDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedListResponseDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedResponseDto;
import java.util.List;

public interface ScheduleService {

    void createSchedule(SkedCreateRequestDto skedCreateRequestDto);

    List<SkedListResponseDto> getAllSchedules();

    List<SkedListResponseDto> searchSchedulesByTitle(String title);

    SkedResponseDto getScheduleById(Long id);
}
