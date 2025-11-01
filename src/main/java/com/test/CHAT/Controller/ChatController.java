package com.test.CHAT.Controller;

import com.test.CHAT.DTO.SMSDTO.SMSRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void sendMessage(@Payload SMSRequestDTO chatMessage) {
        // Pour un test simple, on renvoie le message à tout le monde sur un topic public.
        // Plus tard, nous enverrons à un utilisateur spécifique.
        simpMessagingTemplate.convertAndSend("/topic/public", chatMessage);
    }
}
