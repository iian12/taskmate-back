package com.jygoh.taskmate.domain.schedule.service;

import com.jygoh.taskmate.domain.schedule.dto.SkedCreateRequestDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedListResponseDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedResponseDto;
import com.jygoh.taskmate.domain.schedule.model.Schedules;
import com.jygoh.taskmate.domain.schedule.repository.ScheduleRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void createSchedule(SkedCreateRequestDto skedCreateRequestDto) {

        Schedules schedules = skedCreateRequestDto.toEntity();

        scheduleRepository.save(schedules);
    }

    @Override
    public List<SkedListResponseDto> getAllSchedules() {

        List<Schedules> schedules = scheduleRepository.findAll();

        return SkedListResponseDto.fromEntityList(schedules);
    }

    @Override
    public List<SkedListResponseDto> searchSchedulesByTitle(String title) {

        List<Schedules> schedules = scheduleRepository.findByTitleContainingIgnoreCase(title);

        return SkedListResponseDto.fromEntityList(schedules);
    }

    @Override
    public SkedResponseDto getScheduleById(Long id) {
        Schedules schedules = scheduleRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));

        return SkedResponseDto.fromEntity(schedules);
    }
}
