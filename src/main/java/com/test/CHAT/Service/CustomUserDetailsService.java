package com.test.CHAT.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.CHAT.Entities.User;
import com.test.CHAT.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("--- CustomUserDetailsService: loading user: " + username + " ---");
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.err.println("!!! CustomUserDetailsService: User not found: " + username + " !!!");
                    return new UsernameNotFoundException("Utilisateur non trouvé : " + username);
                });

        System.out.println("--- CustomUserDetailsService: User found in DB ---");
        boolean isAccountNonLocked = user.getIsActive() != null && user.getIsActive();
        System.out.println("--- CustomUserDetailsService: isAccountNonLocked = " + isAccountNonLocked + " ---");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,  // enabled
                true,  // accountNonExpired
                true,  // credentialsNonExpired
                isAccountNonLocked, // accountNonLocked
                java.util.Collections.emptyList()  // pas encore de rôles
        );
    }

}
