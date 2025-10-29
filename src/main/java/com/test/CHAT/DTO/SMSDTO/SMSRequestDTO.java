package com.test.CHAT.DTO.SMSDTO;

import com.test.CHAT.Entities.User;
import com.test.CHAT.Enum.MessageType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SMSRequestDTO {

    private User sender;
    private String content;
    private MessageType messageType;
}
