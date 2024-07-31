package com.sample.infrastructure.member;


import com.sample.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByKakaoId(Long kakaoId);
    boolean existsByKakaoId(Long kakaoId);
}
