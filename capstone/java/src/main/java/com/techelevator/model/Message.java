package com.techelevator.model;

public class Message {
    private int msgId;
    private int senderId;
    private int receiverId;
    private String time_stamp;
    private String message_text; //message_message_text from database
    private String attachment;
    private boolean archive;


    public Message(){ }

    public Message(int msgId, int senderId, int receiverId, String time_stamp, String message_text, String attachment, boolean archive){
        this.msgId = msgId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.time_stamp = time_stamp;
        this.message_text = message_text;
        this.attachment = attachment;
        this.archive = archive;
    }

    public int getMsgId(){ return msgId; }
    public void setMsgId(int msgId){ this.msgId = msgId; }

    public int getSenderId(){ return senderId; }
    public void setSenderId(int senderId){ this.senderId = senderId; }

    public int getReceiverId(){ return receiverId; }
    public void setReceiverId(int receiverId){ this.receiverId = receiverId; }

    public String getTime_stamp(){ return time_stamp; }

    public void setTime_stamp(String time_stamp){ this.time_stamp = time_stamp; }


    public String getMessage_text(){ return message_text; }
    public void setMessage_text(String message_text){ this.message_text = message_text; }

    public String getAttachment(){ return attachment; }
    public void setAttachment(String attachment){ this.attachment = attachment; }

    public boolean isArchive(){ return archive; }
    public void setArchive(boolean archive){ this.archive = archive; }


 }
