package com.primetradebackend.service;

import com.primetradebackend.dto.AuthResponse;
import com.primetradebackend.dto.LoginRequest;
import com.primetradebackend.dto.RegisterRequest;
import com.primetradebackend.entity.Role;
import com.primetradebackend.entity.User;
import com.primetradebackend.repo.UserRepository;
import com.primetradebackend.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequest register){
        if(userRepository.existsByEmail(register.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(register.getName());
        user.setContact(register.getContact());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        return "User register successfully";
    }

    public AuthResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);

    }

}
