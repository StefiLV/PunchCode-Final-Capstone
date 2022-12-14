package com.techelevator.controller;


import com.techelevator.dao.EventDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventDao eventDao;

    public EventController(EventDao eventDao){
        this.eventDao = eventDao;
    }

}
