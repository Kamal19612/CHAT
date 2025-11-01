package com.test.CHAT.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String password;

    // permet de stocker l'URL de l'avatar de l'utilisateur
    private String avatarURL;

    // permet de stocker la date de création et de mise à jour de l'utilisateur
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    // permet de stocker la date de mise à jour de l'utilisateur
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private Boolean isActive;

    private String role; // ex: "ROLE_USER", "ROLE_ADMIN"

}
