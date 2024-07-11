package com.jygoh.taskmate.domain.schedule.controller;

import com.jygoh.taskmate.domain.schedule.dto.SkedCreateRequestDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedListResponseDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedResponseDto;
import com.jygoh.taskmate.domain.schedule.repository.ScheduleRepository;
import com.jygoh.taskmate.domain.schedule.service.ScheduleService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleService scheduleService,
                              ScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping
    public ResponseEntity<List<SkedListResponseDto>> getAllSchedules() {
        List<SkedListResponseDto> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkedResponseDto> getSchedule(@PathVariable Long id) {
        try {
            SkedResponseDto schedule = scheduleService.getScheduleById(id);
            return ResponseEntity.ok(schedule);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<SkedListResponseDto>> searchSchedulesByTitle(
            @RequestParam(required = false) String title) {
        List<SkedListResponseDto> schedules;
        if (title != null && !title.isEmpty()) {
            schedules = scheduleService.searchSchedulesByTitle(title);
        } else {
            schedules = null;
        }

        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    @PostMapping
    public ResponseEntity<String> createSchedule(
            @RequestBody SkedCreateRequestDto skedCreateRequestDto) {
        scheduleService.createSchedule(skedCreateRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Schedule created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Schedule deleted");
    }
}
