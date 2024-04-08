package com.workwise.emailservice.event;

import com.workwise.emailservice.mail.Mail;
import io.grpc.stub.StreamObserver;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.event.EventReceive;
import io.kubemq.sdk.event.Subscriber;
import io.kubemq.sdk.subscription.EventsStoreType;
import io.kubemq.sdk.subscription.SubscribeRequest;
import io.kubemq.sdk.subscription.SubscribeType;
import io.kubemq.sdk.tools.Converter;

import javax.net.ssl.SSLException;
import java.io.IOException;

public class MailEvent {

    public static void receiveSignupMail() throws SSLException, ServerAddressNotSuppliedException {
        String clientId = "signup";
        String kubeMQAddress = System.getenv("KUBEMQ_ADDRESS");

        SubscribeRequest subscribeRequest = new SubscribeRequest();
        subscribeRequest.setChannel("signup-email");
        subscribeRequest.setClientID(clientId);
        subscribeRequest.setSubscribeType(SubscribeType.EventsStore);
        subscribeRequest.setEventsStoreType(EventsStoreType.StartAtSequence);
        subscribeRequest.setEventsStoreTypeValue(1);

        Subscriber subscriber = new Subscriber(kubeMQAddress);
        subscriber.SubscribeToEvents(subscribeRequest, processEmails());
    }

    public static StreamObserver<EventReceive> processEmails() {
        return new StreamObserver<EventReceive>() {
            private String email;
            @Override
            public void onNext(EventReceive value) {
                try {
                    this.email = (String) Converter.FromByteArray(value.getBody());

                    Mail.sendSignupEmail(this.email);
                } catch (ClassNotFoundException e) {
                    System.out.printf("ClassNotFoundException: %s", e.getMessage());
                } catch (IOException e) {
                    System.out.printf("IOException: %s", e.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.printf("failed to send email to %s", this.email);
            }

            @Override
            public void onCompleted() {
                System.out.printf("sent email to %s", this.email);
            }
        };
    }
}
