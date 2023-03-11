package com.company;

public class Main {

    public static void main(String[] args) {
        ChatMediator mediator=new ChatMediatorImpl();

        User user1=(new ChatUser(mediator,"Alfred"));
        User user2=(new ChatUser(mediator,"Toni"));
        User user3=(new ChatUser(mediator,"Frank"));
        User user4=(new ChatUser(mediator,"Einstein"));

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user3.sendMessage("Hola a todos");
    }
}
