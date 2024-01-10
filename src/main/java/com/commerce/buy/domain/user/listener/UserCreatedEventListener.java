package com.commerce.buy.domain.user.listener;

import com.commerce.buy.domain.user.event.UserCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListener implements ApplicationListener<UserCreatedEvent> {
    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        System.out.println(event.getUser().toString() + " okok");
    }
}
