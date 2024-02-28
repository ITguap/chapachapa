package com.example.registrauth.service;

import com.example.registrauth.model.Role;
import com.example.registrauth.model.User;
import com.example.registrauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getByLogin(String login){return userRepository.findByLogin(login);}

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_ADMIN);
        userRepository.save(user);
    }
}
