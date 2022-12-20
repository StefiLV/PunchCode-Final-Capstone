package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.Event;


@Component
public class JdbcEventDao implements EventDao {

    private JdbcTemplate jdbcEventTemplate;


    public JdbcEventDao(JdbcTemplate jdbcEventTemplate) {
        this.jdbcEventTemplate = jdbcEventTemplate;
    }

    @Override
    public List<Event> list() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event";

        SqlRowSet results = jdbcEventTemplate.queryForRowSet(sql);
        while(results.next()) {
            Event event = mapRowToEvent(results);
            events.add(event);
        }
        return events;
    }
    @Override
    public Event findById(int id){
        Event event = null;
        String sql = "SELECT * FROM event WHERE id = ? ";
        SqlRowSet results = jdbcEventTemplate.queryForRowSet(sql, id);
        if(results.next()){
            event = mapRowToEvent(results);
        } else {
            throw new RuntimeException("Id not found. ");
        }
        return event;
    }

    //    @Override
//    public Event findByName(String name){
//        Event event = null;
//        String sql = "SELECT * FROM event WHERE name = ? ";
//        SqlRowSet results = jdbcEventTemplate.queryForRowSet(sql, name);
//        if(results.next()){
//            event = mapRowToEvent(results);
//        } else {
//            throw new EventNotFoundException();
//        }
//        return event;
//    }
    @Override
    public boolean updateEvent(Event event, int id){
        String sql = "UPDATE event SET name = ?, org_owner = ?, org_logo = ?, address = ?, start_date = ?, end_date = ?, start_time = ?, end_time = ?, description = ?, user_counter = ? WHERE id = ? ";
        return jdbcEventTemplate.update(sql, event.getName(), event.getownerId(), event.getOrgLogo(), event.getAddress(), event.getStartDate(), event.getEndDate(), event.getStartTime(), event.getEndTime(), event.getDescription(), event.getCounter(), id) == 1;
    }

    @Override
    public void createEvent(Event eventToCreate){
        String sql = "INSERT INTO event (id, name, org_owner, org_logo, address, start_date, end_date, start_time, end_time, description, user_counter) VALUES ( DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcEventTemplate.update(sql, eventToCreate.getName(), eventToCreate.getownerId(), eventToCreate.getOrgLogo(), eventToCreate.getAddress(), eventToCreate.getStartDate(), eventToCreate.getEndDate(), eventToCreate.getStartTime(), eventToCreate.getEndTime(), eventToCreate.getDescription(), eventToCreate.getCounter());
    }
    @Override
    public void deleteEvent(int id) {
        String sql = "DELETE FROM event WHERE id = ? ";
        jdbcEventTemplate.update(sql, id);
    }

//    @Override
//    public String getProfilePic(){
//        String picFromUser = "";
//        String sql = "SELECT * FROM event " +
//                "JOIN cause ON cause.id = event.id ";
//        SqlRowSet results = jdbcEventTemplate.queryForRowSet(sql);
//        while(results.next()){
//            getProfilePic().add(mapRowToEvent(results));
//        }
//        return picFromUser;
//    }


    private Event mapRowToEvent(SqlRowSet rs) {
        Event ev = new Event();
        ev.setEventId(rs.getInt("id"));
        ev.setName(rs.getString("name"));
        ev.setownerId(rs.getInt("org_owner"));
        ev.setOrgLogo(rs.getString("org_logo"));
        ev.setAddress(rs.getString("address"));
        ev.setStartDate(rs.getString("start_date"));
        ev.setEndDate(rs.getString("end_date"));
        ev.setStartTime(rs.getString("start_time"));
        ev.setEndTime(rs.getString("end_time"));
        ev.setDescription(rs.getString("description"));
        ev.setCounter(rs.getInt("user_counter"));
        return ev;
    };

}