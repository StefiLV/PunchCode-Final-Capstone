package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<User> findAllVols();

    List<User> findAllOrgs();

    User getUserById(int userId);

    User findByUsername(String username);

    boolean update(User user, int id);

    int findIdByUsername(String username);

    List<User> byEventId(int eventId);

    boolean create(String name, String username, String password, String role, boolean organization, String address, String birthDate);

    // I've added organization boolean
    //added a new functions/methods that would enable a search for organization by its name
    //String findOrgByOrgName(String orgName);
}
