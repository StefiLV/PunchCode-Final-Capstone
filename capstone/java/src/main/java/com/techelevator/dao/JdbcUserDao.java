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
public class JdbcUserDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Email cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from user where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }
        return userId;
    }

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM user WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if (results.next()) {
			return mapRowToUser(results);
		} else {
			throw new UserNotFoundException();
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllVols() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users where organization = false";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllOrgs() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users where organization = true";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Email cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("Users " + username + " was not found.");
   }

    @Override // I've added organization boolean add name
    public boolean create(String username, String password, String role, boolean organization, String address, String birthDate) {
        String insertUserSql = "insert into users  (username,password_hash,role,organization,address,birth_date) values (?,?,?,?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();

        return jdbcTemplate.update(insertUserSql, username, password_hash, ssRole, organization, address, birthDate) == 1;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setName(rs.getString("name"));
        user.setBirthDate(rs.getString("birth_date"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPhoneNumber(rs.getString("address"));
        user.setProfilePic(rs.getString("profile_pic"));
        user.setHeroBanner(rs.getString("hero_banner"));
        user.setOrganization(rs.getBoolean("organization"));
        user.setVerified(rs.getBoolean("verified"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }
}
