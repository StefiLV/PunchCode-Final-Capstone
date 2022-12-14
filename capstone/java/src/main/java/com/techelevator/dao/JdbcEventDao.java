package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcEventDao implements EventDao {

    private final JdbcTemplate jdbcEventTemplate;

    public JdbcEventDao(JdbcTemplate jdbcEventTemplate) {
        this.jdbcEventTemplate = jdbcEventTemplate;
    }

    @Override
    public int findIdByName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");

        int eventId;
        try {
            eventId = jdbcEventTemplate.queryForObject("select event_id from event where name = ?", int.class, name);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + name + " was not found.");
        }

        return eventId;
    }

    @Override
    public Event getEventById(int eventId) {
        String sql = "SELECT * FROM event WHERE event_id = ?";
        SqlRowSet results = jdbcEventTemplate.queryForRowSet(sql, eventId);
        if (results.next()) {
            return mapRowToUser(results);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "select * from event";

        SqlRowSet results = jdbcEventTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            event.add(event);
        }

        return events;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String password, String role) {
        String insertUserSql = "insert into users (username,password_hash,role) values (?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();

        return jdbcEventTemplate.update(insertUserSql, username, password_hash, ssRole) == 1;
    }
    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }

}