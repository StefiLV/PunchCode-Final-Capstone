package com.techelevator.dao;

import com.techelevator.model.EventUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcEventUserDao implements EventUserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEventUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<EventUser> getAll(){
        List<EventUser> eUsers = new ArrayList<>();
        String sql = "SELECT * FROM event_user ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            EventUser users = mapRowToEUsers(results);
            eUsers.add(users);
        }
        return eUsers;
    }
    @Override
    public boolean updateStatus(EventUser eu, int id){
        String sql = "UPDATE event_user SET user_id = ?, event_id = ?, approval_status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, eu.getUserId(), eu.getEventId(), eu.getApproval(), id) == 1;
    }
    @Override
    public boolean create(EventUser eu){
        String sql = "INSERT INTO event_user (id, user_id, event_id, approval_status) VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, eu.getUserId(), eu.getEventId(), eu.getApproval()) == 1;
    }


    private EventUser mapRowToEUsers(SqlRowSet eu){
        EventUser evs = new EventUser();
        evs.setEuId(eu.getInt("id"));
        evs.setUserId(eu.getInt("user_id"));
        evs.setEventId(eu.getInt("event_id"));
        evs.setApproval(eu.getString("approval_status"));
        return evs;
    }
}
