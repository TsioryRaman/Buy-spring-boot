package com.commerce.buy.http.api.websocket;

import com.commerce.buy.infrastructure.repository.ProductRepository;
import com.commerce.buy.infrastructure.websocket.WebSocketHandler;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@ServerEndpoint("websocket")
public class ProductSocket {
    private WebSocketSession session;
    @OnOpen
    public void onCreateSession(WebSocketSession session)
    {
        System.out.println("session = " + session.getId());
        this.session = session;
    }

    @OnMessage
    public void onTextMessage(String message) throws IOException {
        this.session.sendMessage(new TextMessage("Salut, Websocket ok"));
    }

}
