package com.sample.domain.member.kakao;

import com.sample.domain.member.MemberLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KakaoLoginService implements MemberLoginService {
    private final TokenRequestCaller tokenRequestCaller;
    private final UserInfoRequestCaller userInfoRequestCaller;

    @Override
    public String getAccessToken(String loginCallbackCode) {
        KakaoTokenResponse call = tokenRequestCaller.call(loginCallbackCode);
        System.out.println("call.accessToken = " + call.accessToken);
        KakaoUserResponse userInfo = userInfoRequestCaller.call(call.accessToken);
        System.out.println("userInfo = " + userInfo);

        userInfo.getKakaoAccount().getEmail();
        return call.idToken;
    }
}
