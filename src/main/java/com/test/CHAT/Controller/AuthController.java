package com.test.CHAT.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.CHAT.DTO.AuthResponseDTO;
import com.test.CHAT.DTO.LoginRequestDTO;
import com.test.CHAT.DTO.RegisterRequestDTO;
import com.test.CHAT.Service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/creer")
    public ResponseEntity<?> register(@RequestBody @Validated RegisterRequestDTO dto) {
        authService.register(dto);
        return ResponseEntity.ok("Utilisateur créé avec succès");
    }

    @PostMapping("/connecter")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Validated LoginRequestDTO dto) {
        System.out.println("--- AuthController: /login endpoint hit ---");
        System.out.println("Login DTO username: " + dto.getUsername());
        String token = authService.login(dto);
        System.out.println("--- AuthController: Token generated ---");
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}
