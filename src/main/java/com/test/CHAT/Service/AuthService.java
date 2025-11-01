package com.test.CHAT.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.CHAT.DTO.LoginRequestDTO;
import com.test.CHAT.DTO.RegisterRequestDTO;
import com.test.CHAT.DTO.UserDTO.userMapper;
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
    private final CustomUserDetailsService userDetailsService;

    public void register(RegisterRequestDTO dto) {
        User user = userMapper.toUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setIsActive(true); // Initialiser isActive

        userRepository.save(user);
    }

    public String login(LoginRequestDTO dto) {
        System.out.println("--- AuthService: login method started ---");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );
            System.out.println("--- AuthService: Authentication successful ---");

            final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
            System.out.println("--- AuthService: UserDetails loaded ---");

            String token = jwtService.generateToken(userDetails);
            System.out.println("--- AuthService: Token generation complete ---");
            return token;
        } catch (AuthenticationException e) {
            System.err.println("!!! AuthService: EXCEPTION during login !!!");
            throw e; // re-throw the exception
        }
    }

}
