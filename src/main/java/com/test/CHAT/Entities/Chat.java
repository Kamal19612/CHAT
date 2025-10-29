package com.test.CHAT.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
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
@Table(name = "Chats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Chat implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;
    
    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;
    
    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

}
