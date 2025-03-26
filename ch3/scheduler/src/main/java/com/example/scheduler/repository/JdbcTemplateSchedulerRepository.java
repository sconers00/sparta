package com.example.scheduler.repository;

import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.dto.SchedulerSearchResponseDto;
import com.example.scheduler.entity.Schedule;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

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
        //Insert query 직접 작성 안해도 됨.
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", schedule.getName());
        parameters.put("todo", schedule.getTodo());
        parameters.put("pswd", schedule.getPswd());
        parameters.put("postdate", formatedNow);
        parameters.put("editdate", formatedNowT);
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new SchedulerResponseDto(key.longValue(), schedule.getName(), schedule.getTodo(), schedule.getPswd(),formatedNow,formatedNow);
    }

    @Override
    public List<SchedulerSearchResponseDto> findSchedules(String name, String postdate) {
        /*if (name == null && postdate == null) { 구분기능 해결중...
            return jdbcTemplate.query("select * from scheduler Order by editdate desc", schedulerRowMapper());
        } else if (postdate == null) {
            return jdbcTemplate.query("select * from scheduler where name = ? Order by editdate desc", schedulerRowMapper(), name);
        } else if (name == null) {
            return jdbcTemplate.query("select * from scheduler where postdate = ? Order by editdate desc", schedulerRowMapper(), postdate);
        } else {
            return jdbcTemplate.query("select * from scheduler where name = ? and postdate = ? Order by editdate desc", schedulerRowMapper(), name, postdate);
        }*/
        return jdbcTemplate.query("select * from scheduler Order by editdate desc", schedulerRowMapper());
    }

   /* @Override 고장
    public Optional<Schedule> findSchedulerByIdOrElseThrow(Long id) {
        List<Schedule> result = jdbcTemplate.query("select * from schedule where id = ?", schedulerRowMapper2(),id);
        return result.stream().findAny();
    }*/





    private RowMapper<SchedulerSearchResponseDto> schedulerRowMapper() {
        return new RowMapper<SchedulerSearchResponseDto>() {
            @Override
            public SchedulerSearchResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new SchedulerSearchResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getString("postdate"),
                        rs.getString("editdate")
                );
            }

        };
    }
    private RowMapper<Schedule> schedulerRowMapper2(){
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
