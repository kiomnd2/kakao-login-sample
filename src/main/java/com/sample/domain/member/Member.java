package com.sample.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 100 , unique = true)
    private Long kakaoId;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String phoneNo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public Member(Long kakaoId, String name, String email, String phoneNo, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.kakaoId = kakaoId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
