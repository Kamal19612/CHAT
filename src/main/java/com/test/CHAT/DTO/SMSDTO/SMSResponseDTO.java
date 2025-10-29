package com.test.CHAT.DTO.SMSDTO;

import com.test.CHAT.Entities.User;
import com.test.CHAT.Enum.MessageType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SMSResponseDTO {

    private User sender;  // pratique pour l'affichage
    private String content;
    private MessageType messageType;
}