package com.jygoh.taskmate;

import com.jygoh.taskmate.domain.schedule.dto.SkedCreateRequestDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedListResponseDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedResponseDto;
import com.jygoh.taskmate.domain.schedule.model.Schedules;
import com.jygoh.taskmate.domain.schedule.repository.ScheduleRepository;
import com.jygoh.taskmate.domain.schedule.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ScheduleServiceImplTest {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @BeforeEach
    public void setUp() {
        scheduleRepository.deleteAll();
    }

    @Test
    public void testCreateSchedule() {
        SkedCreateRequestDto skedCreateRequestDto = SkedCreateRequestDto.builder()
                .title("Test Title")
                .description("Test Description")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(1))
                .userId(1L)
                .categoryId(1L)
                .build();

        scheduleService.createSchedule(skedCreateRequestDto);

        List<Schedules> schedulesList = scheduleRepository.findAll();
        assertEquals(1, schedulesList.size());
        assertEquals("Test Title", schedulesList.get(0).getTitle());
    }

    @Test
    public void testGetAllSchedules() {
        Schedules schedule1 = Schedules.builder()
                .title("Title 1")
                .description("Description 1")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(1))
                .userId(1L)
                .categoryId(1L)
                .build();
        Schedules schedule2 = Schedules.builder()
                .title("Title 2")
                .description("Description 2")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(2))
                .userId(2L)
                .categoryId(2L)
                .build();
        scheduleRepository.save(schedule1);
        scheduleRepository.save(schedule2);

        List<SkedListResponseDto> result = scheduleService.getAllSchedules();

        assertEquals(2, result.size());
    }

    @Test
    public void testSearchSchedulesByTitle() {
        Schedules schedule1 = Schedules.builder()
                .title("Test Title 1")
                .description("Description 1")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(1))
                .userId(1L)
                .categoryId(1L)
                .build();
        Schedules schedule2 = Schedules.builder()
                .title("Another Title")
                .description("Description 2")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(2))
                .userId(2L)
                .categoryId(2L)
                .build();
        scheduleRepository.save(schedule1);
        scheduleRepository.save(schedule2);

        List<SkedListResponseDto> result = scheduleService.searchSchedulesByTitle("Test");

        assertEquals(1, result.size());
        assertEquals("Test Title 1", result.get(0).getTitle());
    }

    @Test
    public void testGetScheduleById() {
        Schedules schedules = Schedules.builder()
                .title("Test Title")
                .description("Test Description")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(1))
                .userId(1L)
                .categoryId(1L)
                .build();
        schedules = scheduleRepository.save(schedules);

        SkedResponseDto result = scheduleService.getScheduleById(schedules.getId());

        assertNotNull(result);
        assertEquals("Test Title", result.getTitle());
    }

    @Test
    public void testGetScheduleById_NotFound() {
        Long id = 1L;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            scheduleService.getScheduleById(id);
        });

        assertEquals("Schedule not found", exception.getMessage());
    }
}
