package com.workwise.userservice.event;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.event.Channel;
import io.kubemq.sdk.tools.Converter;
import io.kubemq.sdk.event.Event;

import javax.net.ssl.SSLException;
import java.io.IOException;

public class SignupEmailEvent {

    public static void sendSignupEmail(String email) throws IOException {
        String kubeMQAddress = System.getenv("KUBEMQ_ADDRESS");

        Channel channel = new Channel("signup-email", "signup", false, kubeMQAddress);

        channel.setStore(true);
        Event event = new Event();
        event.setBody(Converter.ToByteArray(email));
        event.setEventId("event-Store-" );

        try {
            channel.SendEvent(event);
        } catch (SSLException e) {
            System.out.printf("SSLException: %s", e.getMessage());
        } catch (ServerAddressNotSuppliedException e) {
            System.out.printf("ServerAddressNotSuppliedException: %s", e.getMessage());
        }
    }
}
