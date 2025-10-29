package com.test.CHAT.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.CHAT.DTO.LoginRequestDTO;
import com.test.CHAT.DTO.RegisterRequestDTO;
import com.test.CHAT.Entities.User;
import com.test.CHAT.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);
    }

    public String login(LoginRequestDTO dto) {
        // Vérifie les identifiants
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        // Génère le token JWT
        UserDetails user = (UserDetails) userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        return jwtService.generateToken(user);
    }

}
