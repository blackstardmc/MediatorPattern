package com.company;

import java.util.ArrayList;
import java.util.List;


interface ChatMediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}

public class ChatUser extends User {


    ChatUser(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    void sendMessage(String message) {
        System.out.println(this.name + " send Message: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println(this.name + " receive Messagge : " + message);
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    User(ChatMediator chatMediator, String name) {
        this.mediator = chatMediator;
        this.name = name;
    }

    abstract void sendMessage(String message);

    abstract void receiveMessage(String message);
}

class ChatMediatorImpl implements ChatMediator {
    private final List<User> userList;

    public ChatMediatorImpl() {
        userList = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : userList
        ) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.userList.add(user);
    }
}