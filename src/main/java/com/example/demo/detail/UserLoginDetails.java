package com.example.demo.detail;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLoginDetails implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user  = repository.findByUserId(username).orElseThrow(()->new UsernameNotFoundException("유저를 찾을 수 없음"));

        return User.builder()
                .username(user.getUserId())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }

}
