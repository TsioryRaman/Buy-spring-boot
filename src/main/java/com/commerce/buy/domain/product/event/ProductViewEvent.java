package com.commerce.buy.domain.product.event;

import org.springframework.context.ApplicationEvent;

public class ProductViewEvent extends ApplicationEvent {
    public ProductViewEvent(Object source) {
        super(source);
    }
}
