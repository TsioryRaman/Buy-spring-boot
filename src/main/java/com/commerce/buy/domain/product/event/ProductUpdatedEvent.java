package com.commerce.buy.domain.product.event;

import com.commerce.buy.domain.product.model.Product;
import org.springframework.context.ApplicationEvent;

public class ProductUpdatedEvent extends ApplicationEvent {
    public ProductUpdatedEvent(Object source) {
        super(source);
    }

    public Product getProduct()
    {
        return (Product) this.source;
    }
}
