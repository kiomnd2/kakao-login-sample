package com.sample.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailService implements UserDetailsService {
    private final MemberReader memberReader;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberReader.readMember(Long.getLong(username))
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
