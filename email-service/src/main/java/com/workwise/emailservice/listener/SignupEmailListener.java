package com.workwise.emailservice.listener;

import com.workwise.emailservice.event.MailEvent;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;

import javax.net.ssl.SSLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SignupEmailListener implements ServletContextListener {

        @Override
        public void contextDestroyed(ServletContextEvent arg0) {
            System.out.println("ServletContextListener destroyed");
        }

        @Override
        public void contextInitialized(ServletContextEvent arg0) {
            System.out.println("init context");
            Runnable r = () -> {
                try {
                    MailEvent.receiveSignupMail();
                } catch (SSLException | ServerAddressNotSuppliedException e) {
                    System.out.println(e.getMessage());
                }
            };

            new Thread(r).start();
        }
}
