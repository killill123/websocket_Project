package com.example.demo.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String userId;
    private String password;
    private String rule;

    @Builder // 빌더 패턴 적용
    public UserEntity(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.rule = rule;
    }

}
