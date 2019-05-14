package com.dennisoconnell.javamicroservicedemo.wishlist.infrastructure;



import org.springframework.stereotype.Component;

@Component
public class MqReciever {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
