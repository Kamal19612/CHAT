package com.test.CHAT.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.test.CHAT.Enum.MessageType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "SMS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SMS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // il permet de savoir à quel chat ce message appartient
    @ManyToOne
    @JoinColumn(name = "idChat")
    private Chat chat;

    // la personne qui envoie le message
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    
    private String content;
    
    @Enumerated(EnumType.STRING)
    private MessageType messageType;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

}

