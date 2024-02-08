package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.example.demo.handler.SocketHandler;

//@ComponentScan("controllers")
@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer { // (1)
    @Autowired
    SocketHandler socketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler, "/chating/{roomNumber}").setAllowedOrigins("*")
		.addInterceptors(new HttpSessionHandshakeInterceptor()); // (2)
    }

    @Bean
    // 빈 등록은 public 안 해줘야됨! 있을 필요가 없어서~
    ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean(); // (3)
        container.setMaxTextMessageBufferSize(500000); // (4)
        container.setMaxBinaryMessageBufferSize(500000); // (5)
        return container;
    }
}