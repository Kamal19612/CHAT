package com.test.CHAT.DTO.SMSDTO;

import org.springframework.stereotype.Component;



@Component
public class SMSMapperDTO {

    // conversion request DTO to entity
    public static com.test.CHAT.Entities.SMS toEntity(SMSRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return com.test.CHAT.Entities.SMS.builder()
                .senderUserName(dto.getSenderUserName())
                .content(dto.getContent())
                .messageType(dto.getMessageType())
                .build();
    }
    // conversion entity to response DTO
    public static SMSResponseDTO toDTO(com.test.CHAT.Entities.SMS entity) {
        if (entity == null) {
            return null;
        }
        return SMSResponseDTO.builder()
                .senderUserName(entity.getSenderUserName())
                .content(entity.getContent())
                .messageType(entity.getMessageType())
                .build();
    }
}
