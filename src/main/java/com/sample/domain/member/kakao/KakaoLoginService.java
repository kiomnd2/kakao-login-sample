package com.sample.domain.member.kakao;

import com.sample.domain.member.MemberLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KakaoLoginService implements MemberLoginService {
    private final TokenRequestCaller tokenRequestCaller;

    @Override
    public String getAccessToken(String LoginCallbackCode) {
        return "";
    }
}
