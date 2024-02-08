package com.example.demo.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChatHandler extends TextWebSocketHandler {

   // message
   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

   }

   // connection established
   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {

   }

   // connection closed
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
   
   }

}