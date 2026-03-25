package com.example.demo.service;

import com.example.demo.CustomExeption.UserSignupException;
import com.example.demo.DTO.UserSignupDto;
import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserSignupDto dto){

        repository.findByUserId(dto.getUserId()).ifPresent(user -> {
            throw new UserSignupException("이미 존재하는 아이디");
        });
         UserEntity user = UserEntity.builder()
                 .userId(dto.getUserId())
                 .password(passwordEncoder.encode(dto.getPassword()))
                 .build();


        repository.save(user);
    }


}
