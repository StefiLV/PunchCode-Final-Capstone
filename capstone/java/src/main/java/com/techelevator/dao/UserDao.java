package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<User> findAllVols();

    List<User> findAllOrgs();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role, boolean organization);

    //added a new functions/methods that would enable a search for organization by its name
    //String findOrgByOrgName(String orgName);
}
