package com.jygoh.taskmate;

import com.jygoh.taskmate.domain.schedule.dto.SkedCreateRequestDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedListResponseDto;
import com.jygoh.taskmate.domain.schedule.dto.SkedResponseDto;
import com.jygoh.taskmate.domain.schedule.model.Schedules;
import com.jygoh.taskmate.domain.schedule.repository.ScheduleRepository;
import com.jygoh.taskmate.domain.schedule.service.ScheduleService;
import com.jygoh.taskmate.domain.schedule.service.ScheduleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTest {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    private SkedCreateRequestDto skedCreateRequestDto;
    private Schedules schedules;

    @BeforeEach
    public void setUp() {
        skedCreateRequestDto = mock(SkedCreateRequestDto.class);
        schedules = mock(Schedules.class);
    }

    @Test
    public void testCreateSchedule() {
        when(skedCreateRequestDto.toEntity()).thenReturn(schedules);
        scheduleService.createSchedule(skedCreateRequestDto);

        verify(scheduleRepository, times(1)).save(schedules);
    }

    @Test
    public void testGetAllSchedules() {
        List<Schedules> schedulesList = Arrays.asList(schedules);
        when(scheduleRepository.findAll()).thenReturn(schedulesList);

        List<SkedListResponseDto> result = scheduleService.getAllSchedules();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(scheduleRepository, times(1)).findAll();
    }

    @Test
    public void testSearchSchedulesByTitle() {
        String title = "Test Title";
        List<Schedules> schedulesList = Arrays.asList(schedules);
        when(scheduleRepository.findByTitleContainingIgnoreCase(title)).thenReturn(schedulesList);

        List<SkedListResponseDto> result = scheduleService.searchSchedulesByTitle(title);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(scheduleRepository, times(1)).findByTitleContainingIgnoreCase(title);
    }

    @Test
    public void testGetScheduleById() {
        Long id = 1L;
        when(scheduleRepository.findById(id)).thenReturn(Optional.of(schedules));

        SkedResponseDto result = scheduleService.getScheduleById(id);

        assertNotNull(result);
        verify(scheduleRepository, times(1)).findById(id);
    }

    @Test
    public void testGetScheduleById_NotFound() {
        Long id = 1L;
        when(scheduleRepository.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            scheduleService.getScheduleById(id);
        });

        assertEquals("Schedule not found", exception.getMessage());
        verify(scheduleRepository, times(1)).findById(id);
    }
}
