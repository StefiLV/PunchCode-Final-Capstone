package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.Message;


@Component
public class JdbcMessageDao implements MessageDao {

    private JdbcTemplate jdbcMsgTemplate;


    public JdbcMessageDao(JdbcTemplate jdbcMsgTemplate) {
        this.jdbcMsgTemplate = jdbcMsgTemplate;
    }

    @Override
    public List<Message> list(){
        List<Message> msgs = new ArrayList<>();
        String sql = "SELECT * FROM message ";

        SqlRowSet results = jdbcMsgTemplate.queryForRowSet(sql);
        while(results.next()){
            Message msg = mapRowToMessage(results);
            msgs.add(msg);
        }
        return msgs;
    }
    @Override
    public Message getById(int msgId){
        Message message = null;
        String sql = "SELECT * FROM message WHERE id = ? ";
        SqlRowSet results = jdbcMsgTemplate.queryForRowSet(sql, msgId);
        if(results.next()){
            message = mapRowToMessage(results);
        } else {
            throw new RuntimeException("Id not found. ");
        }
        return message;
    }
    @Override
    public void createMsg(Message newMsg){
        String sql = "INSERT INTO message (id, sender_id, receiver_id, time_stamp, message_text, attachment, archive) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcMsgTemplate.update(sql, newMsg.getMsgId(), newMsg.getSenderId(), newMsg.getReceiverId(), newMsg.getTime_stamp(), newMsg.getMessage_text(), newMsg.getAttachment(), newMsg.isArchive());

    }
    @Override
    public boolean updateMsg(Message msg, int id){
        String sql = "UPDATE message SET time_stamp = ?, message_text = ?, attachment = ?, archive = ? ";

        return jdbcMsgTemplate.update(sql, msg.getTime_stamp(), msg.getMessage_text(),  msg.getAttachment(), msg.isArchive()) == 1;

    }
    @Override
    public void deleteMsg(int msgId){
        String sql = "DELETE FROM message WHERE id = ? ";
        jdbcMsgTemplate.update(sql, msgId);
    }

    private Message mapRowToMessage(SqlRowSet mg){
        Message io = new Message();
        io.setMsgId(mg.getInt("id"));
        io.setSenderId(mg.getInt("sender_id"));
        io.setReceiverId(mg.getInt("receiver_id"));
        io.setTime_stamp(mg.getString("time_stamp"));
        io.setMessage_text(mg.getString("message_text"));
        io.setAttachment(mg.getString("attachment"));
        io.setArchive(mg.getBoolean("archive"));
        return io;
    }
}

















