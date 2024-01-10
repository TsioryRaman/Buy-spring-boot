package com.commerce.buy.domain.user.event;

import com.commerce.buy.domain.user.model.User;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
    public UserCreatedEvent(Object source) {
        super(source);
    }

    public User getUser()
    {
        return this.source instanceof User ? (User) this.source : null;
    }
}
