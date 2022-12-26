package com.aueb.socialmediaapplication.Database;

import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.util.ArrayList;

public class PseudoDatabase {

    public static UserDatabase fillWithUsers(){
        User user1 = new User("ObiWanKenobi","111");
        User user2 = new User("AnakinSkywalker","222");
        User user3 = new User("DarthMaul","333");
        User user4 = new User("LukeSkywalker","444");
        User user5 = new User("TheMandalorian","555");

        Message m1 = new Message("hello there", user1.getUserName(),user2.getUserName(),0);
        Message m2 = new Message("general kenobi", user2.getUserName(),user1.getUserName(),1);
        Message m3 = new Message("you are a bold one", user1.getUserName(),user3.getUserName(),2);
        Message m4 = new Message("I have a bad feeling about this", user3.getUserName(),user1.getUserName(),3);
        Message m5 = new Message("You again?", user1.getUserName(),user3.getUserName(),4);
        Message m6 = new Message("Feel the force around you", user4.getUserName(),user1.getUserName(),5);
        Message m7 = new Message("This is the way", user1.getUserName(),user5.getUserName(),6);

        ArrayList<Message> messagesSent1 = new ArrayList<>();
        messagesSent1.add(m1);
        messagesSent1.add(m3);
        messagesSent1.add(m5);
        messagesSent1.add(m7);

        user1.setMessagesSent(messagesSent1);

        ArrayList<Message> messagesSent2 = new ArrayList<>();
        messagesSent2.add(m2);

        user2.setMessagesSent(messagesSent2);

        ArrayList<Message> messagesSent3 = new ArrayList<>();
        messagesSent2.add(m4);

        user3.setMessagesSent(messagesSent3);

        ArrayList<Message> messagesSent4 = new ArrayList<>();
        messagesSent4.add(m6);

        user4.setMessagesSent(messagesSent4);

        ArrayList<Message> messagesReceived1 = new ArrayList<>();
        messagesReceived1.add(m2);
        messagesReceived1.add(m4);
        messagesReceived1.add(m6);

        user1.setMessagesReceived(messagesReceived1);

        ArrayList<Message> messagesReceived2 = new ArrayList<>();
        messagesReceived1.add(m1);

        user2.setMessagesReceived(messagesReceived2);

        ArrayList<Message> messagesReceived3 = new ArrayList<>();
        messagesReceived3.add(m3);
        messagesReceived3.add(m5);

        user3.setMessagesReceived(messagesReceived3);

        ArrayList<Message> messagesReceived4 = new ArrayList<>();
        messagesReceived4.add(m7);

        user5.setMessagesReceived(messagesReceived4);

        UserDatabase userdb = new UserDatabase();

        userdb.register(user1);
        userdb.register(user2);
        userdb.register(user3);
        userdb.register(user4);
        userdb.register(user5);

        return userdb;
    }
}
