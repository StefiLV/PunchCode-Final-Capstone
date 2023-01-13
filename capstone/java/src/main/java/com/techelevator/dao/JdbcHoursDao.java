package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Hours;
import org.springframework.stereotype.Component;

@Component
public class JdbcHoursDao implements HoursDao {


    private JdbcTemplate jdbcTemplate;

    public JdbcHoursDao (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

@Override
public List<Hours> getAllHours(){
        List<Hours> hours = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM hours;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            hours.add(mapRowToHours(results));
        }
        return hours;
}

    @Override
    public Hours getId(int id){ //getting individual ids
        Hours hours = null;
        String sql = "SELECT * " +
                "FROM hours " +
                "WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()){
            hours = mapRowToHours(results);
        }
        return hours;
    }

    @Override
    public Hours createId(Hours newId){ //creating a new id for hours
        String sql = "INSERT INTO hours ( user_id, event_id, hours, approval_status)" +
                " VALUES (?,?,?,?) RETURNING id;";
     Integer newid = jdbcTemplate.queryForObject(sql, Integer.class, newId.getUser_id(), newId.getEvent_id(), newId.getHours(), newId.getApproval_status());

     return getId(newid);
    }

    @Override
    public void deleteId (int id) { //delete hours from
        String sql = "DELETE FROM users WHERE user_id = (SELECT user_id FROM hours WHERE id = ?); " +
                "DELETE FROM event WHERE event_id = (SELECT event_id FROM hours WHERE ID = ?); " +
                "DELETE FROM hours WHERE id = ?";
        jdbcTemplate.update(sql, id, id, id);
    }

    @Override
    public void updateHours (Hours updatedHours, int updateId){
        String sql ="UPDATE hours " +
                "SET hours = ? " +
                "WHERE id = ?;";
        jdbcTemplate.update(sql, updatedHours.getHours(), updatedHours.getId(), updateId);
    }





    private Hours mapRowToHours(SqlRowSet results){
        Hours hours = new Hours();
        hours.setId(results.getInt("id"));
        hours.setEvent_id(results.getInt("event_id"));
        hours.setHours(results.getInt("hours"));
        hours.setUser_id(results.getInt("user_id"));
        hours.setApproval_status(results.getString("approval_status"));
        return hours;
    }


}
