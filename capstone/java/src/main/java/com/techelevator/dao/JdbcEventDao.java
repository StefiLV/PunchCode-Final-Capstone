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
        String sql = "SELECT * FROM event ";

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
        String sql = "SELECT * FROM event WHERE event_id = ? ";
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
        String sql = "UPDATE event SET name = ?, address = ?, start_date = ?, end_date = ?, start_time = ?, end_time = ?, description = ?, counter = ? WHERE id = ? ";
       return jdbcEventTemplate.update(sql, event.getName(), event.getAdress(), event.getStartDate(), event.getEndDate(), event.getStartTime(), event.getEndTime(), event.getDescription(), event.getCounter(), id) == 1;
    }

    @Override
    public void createEvent(Event eventToCreate){
        String sql = "INSERT INTO event (event_id, name, address, start_date, end_date, start_time, end_time, description, counter) VALUES ( DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcEventTemplate.update(sql, eventToCreate.getName(), eventToCreate.getAdress(), eventToCreate.getStartDate(), eventToCreate.getEndDate(), eventToCreate.getStartTime(), eventToCreate.getEndTime(), eventToCreate.getDescription(), eventToCreate.getCounter());
    }
    @Override
    public void deleteEvent(int id) {
        String sql = "DELETE FROM event WHERE id = ? ";
         jdbcEventTemplate.update(sql, id);
    }


    private Event mapRowToEvent(SqlRowSet rs) {
        Event ev = new Event();
        ev.setEventId(rs.getInt("event_id"));
        ev.setName(rs.getString("name"));
        ev.setAddress(rs.getString("address"));
        ev.setStartDate(rs.getString("start_date"));
        ev.setEndDate(rs.getString("end_date"));
        ev.setStartTime(rs.getString("start_time"));
        ev.setEndTime(rs.getString("end_time"));
        ev.setDescription(rs.getString("description"));
        ev.setCounter(rs.getInt("counter"));
        return ev;
    };

}
