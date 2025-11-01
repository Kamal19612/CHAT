package com.test.CHAT.DTO.UserDTO;

import org.springframework.stereotype.Component;

import com.test.CHAT.DTO.RegisterRequestDTO;

import lombok.Data;

@Component
@Data
public class userMapper {

    // Méthode pour convertir un RegisterRequestDTO en User entity
    public static com.test.CHAT.Entities.User toUser(RegisterRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return com.test.CHAT.Entities.User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
    // Méthode pour convertir une User entity en userResponseDTO
    public static userResponseDTO toUserResponseDTO(com.test.CHAT.Entities.User user) {
        if (user == null) {
            return null;
        }
        return userResponseDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .avatarURL(user.getAvatarURL())
                .build();
    }

}