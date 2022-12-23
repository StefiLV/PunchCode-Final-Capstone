package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.EventDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class AuthenticationController {


    @Autowired
    EventDao eventDao;

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDTO loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);

        User user = userDao.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponse(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterUserDTO newUser) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new UserAlreadyExistsException();
        } catch (UsernameNotFoundException e) {
            userDao.create(newUser.getName(), newUser.getUsername(), newUser.getPassword(), newUser.getRole(), newUser.isOrganization(), newUser.getAddress(), newUser.getBirthDate());
        }
    }
    @RequestMapping(path = "/api/users", method = RequestMethod.GET)
    public List<User> findAll() {
        List<User> allUsers = userDao.findAll();
        return allUsers;
    }

    @RequestMapping(path = "/api/users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable int id) {
        User users = userDao.getUserById(id);
        if (users == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event Not Found");
        } else {
            return userDao.getUserById(id);
        }
    }
    @RequestMapping(path = "/api/users/{id}", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody User user, @Valid @PathVariable int id){
        userDao.update(user, id);
    }

    @RequestMapping(path = "/api/users/events/{id}", method = RequestMethod.GET)
    public List<User> getEventId(@PathVariable int id) {
        Event event = new Event();
        int eventId = event.getEventId(id);

        return userDao.byEventId(id);

    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class LoginResponse {

        private String token;
        private User user;


        LoginResponse(String token, User user) {
            this.token = token;
            this.user = user;
        }

        @JsonProperty("token")
        String getToken() {
            return token;
        }

        void setToken(String token) {
            this.token = token;
        }

        @JsonProperty("user")
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
    }

}

