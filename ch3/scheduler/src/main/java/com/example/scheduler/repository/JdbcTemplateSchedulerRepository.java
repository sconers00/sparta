package com.example.scheduler.repository;

import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.entity.Schedule;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.stereotype.Repository;


@Repository
public class JdbcTemplateSchedulerRepository implements SchedulerRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateSchedulerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    LocalDate nowD = LocalDate.now();
    String formatedNow = nowD.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDateTime nowDT = LocalDateTime.now();
    String formatedNowT = nowDT.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    @Override
    public SchedulerResponseDto addSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", schedule.getName());
        parameters.put("todo", schedule.getTodo());
        parameters.put("pswd", schedule.getPswd());
        parameters.put("postdate", formatedNow);
        parameters.put("editdate", formatedNowT);
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new SchedulerResponseDto(key.longValue(), schedule.getName(), schedule.getTodo(),formatedNow,formatedNow);
    }

    @Override
    public List<SchedulerResponseDto> findSchedules(String name, String postdate) {
        if (name != null && postdate != null) { //조건부 일정 검색기(이름, 생성일)-최근수정일 기준 정렬
            return jdbcTemplate.query("select * from schedule where name = ? and postdate = ? Order by editdate desc", schedulerRowMapper(), name, postdate);
        } else if (postdate != null) {
            return jdbcTemplate.query("select * from schedule where postdate = ? Order by editdate desc", schedulerRowMapper(), postdate);
        } else if (name != null) {
            return jdbcTemplate.query("select * from schedule where name = ? Order by editdate desc", schedulerRowMapper(), name);
        } else {
            return jdbcTemplate.query("select * from schedule Order by editdate desc", schedulerRowMapper());
        }
    }

    @Override
    public Optional<Schedule> findSchedulerById(Long id) {//id로 검색, 결과가 없다면 null->서비스에서 오류처리
        List<Schedule> result = jdbcTemplate.query("select * from schedule where id = ?", schedulerRowMapper2(),id);
        return result.stream().findAny();
    }






    private RowMapper<SchedulerResponseDto> schedulerRowMapper() {//으어어
        return new RowMapper<SchedulerResponseDto>() {
            @Override
            public SchedulerResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new SchedulerResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getString("postdate"),
                        rs.getString("editdate")
                );
            }

        };
    }
    private RowMapper<Schedule> schedulerRowMapper2(){//으어어어어
        return new RowMapper<Schedule>(){
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException{
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getString("postdate"),
                        rs.getString("editdate")
                );
            }
        };
    }

}
