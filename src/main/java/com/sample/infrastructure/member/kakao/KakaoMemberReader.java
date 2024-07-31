package com.sample.infrastructure.member.kakao;

import com.sample.domain.member.Member;
import com.sample.domain.member.MemberReader;
import com.sample.infrastructure.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class KakaoMemberReader implements MemberReader {
    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> readMember(Long id) {
        return memberRepository.findByKakaoId(id);
    }

    @Override
    public boolean isMember(Long id) {
        return memberRepository.existsByKakaoId(id);
    }


}
