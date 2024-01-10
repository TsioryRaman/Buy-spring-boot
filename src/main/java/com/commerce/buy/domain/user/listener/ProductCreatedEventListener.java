package com.commerce.buy.domain.user.listener;

import com.commerce.buy.domain.product.event.ProductCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedEventListener implements ApplicationListener<ProductCreatedEvent> {
    @Override
    public void onApplicationEvent(ProductCreatedEvent event) {
        System.out.println("Utilisateur notifiee pour le produit " + event.getProduct().getName() + " cree");
    }
}
