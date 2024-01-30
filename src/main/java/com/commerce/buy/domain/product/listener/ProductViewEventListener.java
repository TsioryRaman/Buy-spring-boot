package com.commerce.buy.domain.product.listener;

import com.commerce.buy.domain.product.event.ProductViewEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ProductViewEventListener implements ApplicationListener<ProductViewEvent> {
    @Async
    @Override
    public void onApplicationEvent(ProductViewEvent event) {
        try {
            Thread.sleep(5000);
            System.out.println("event = " + event.getProduct().getName() + " asynchrone ok apres 2secondes");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
