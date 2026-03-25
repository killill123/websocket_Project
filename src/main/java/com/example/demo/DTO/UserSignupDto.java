package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class UserSignupDto {
    private String userId;
    private String password;
}
