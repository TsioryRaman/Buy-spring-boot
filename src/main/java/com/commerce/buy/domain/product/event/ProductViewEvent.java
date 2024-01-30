package com.commerce.buy.domain.product.event;

import com.commerce.buy.domain.product.model.Product;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;

public class ProductViewEvent extends ApplicationEvent {
    public ProductViewEvent(Object source) {
        super(source);
    }

    public Product getProduct()
    {
        return (Product) this.source;
    }
}
