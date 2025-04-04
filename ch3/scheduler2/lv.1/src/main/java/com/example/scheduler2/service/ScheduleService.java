package com.example.scheduler2.service;

import com.example.scheduler2.dto.ScheduleResponseDto;
import com.example.scheduler2.entity.Schedule;
import com.example.scheduler2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String username, String title, String contents){//일정 저장
        Schedule schedule = new Schedule(username, title, contents);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }

    public ScheduleResponseDto findById(Long id) {//id로 일정 조회
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if(optionalSchedule.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id = "+id);
        }
        Schedule findSchedule = optionalSchedule.get();
        return new ScheduleResponseDto(findSchedule.getId(),findSchedule.getUsername(),findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getCreatedAt(), findSchedule.getModifiedAt());
    }

    public List<ScheduleResponseDto> findAll() {// 전체조회용
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();
    }
    @Transactional
    public void updateSchedule(Long id, String title, String contents) {//id로 찾은 일정의 제목, 내용 수정
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        findSchedule.updateSchedule(id, title, contents);
    }

    public void deleteSchedule(Long id) {//일정 삭제용
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
