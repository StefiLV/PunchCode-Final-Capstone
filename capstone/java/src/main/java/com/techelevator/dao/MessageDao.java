package com.techelevator.dao;

import com.techelevator.model.Message;

import java.util.List;

public interface MessageDao {

    void createMsg(Message newMsg);

    List<Message> list();

    Message getById(int msgId);

    boolean updateMsg(Message msg, int msgId);

   void deleteMsg(int msgId);
}
