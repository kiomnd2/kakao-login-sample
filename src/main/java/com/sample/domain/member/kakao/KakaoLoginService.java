package com.sample.domain.member.kakao;

import com.sample.domain.member.MemberLoginService;
import com.sample.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KakaoLoginService implements MemberLoginService {
    private final TokenRequestCaller tokenRequestCaller;
    private final UserInfoRequestCaller userInfoRequestCaller;
    private final MemberReader memberReader;


    @Override
    public AccessTokenRequestResult getAccessToken(String loginCallbackCode) {
        KakaoTokenResponse call = tokenRequestCaller.call(loginCallbackCode);
        KakaoUserResponse userInfo = userInfoRequestCaller.call(call.accessToken);
        long kakaoId = userInfo.getId();

        if (memberReader.isMember(kakaoId)) {
            // 있으면 토큰 발급 후 리턴
        }

        return AccessTokenRequestResult.builder()
                .kakaoId(kakaoId)
                .isJoined(false)
                .build();
    }
}
