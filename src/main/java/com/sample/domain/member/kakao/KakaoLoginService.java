package com.sample.domain.member.kakao;

import com.sample.domain.member.MemberLoginService;
import com.sample.domain.member.MemberReader;
import com.sample.domain.member.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KakaoLoginService implements MemberLoginService {
    private final TokenRequestCaller tokenRequestCaller;
    private final UserInfoRequestCaller userInfoRequestCaller;
    private final MemberReader memberReader;
    private final JwtTokenProvider provider;

    @Override
    public String getAccessToken(String loginCallbackCode) {
        KakaoTokenResponse call = tokenRequestCaller.call(loginCallbackCode);
        return call.getAccessToken();
    }

    @Override
    public CheckUserResult getCheckMember(String accessToken) {
        KakaoUserResponse userResponse = userInfoRequestCaller.call(accessToken);

        if (memberReader.isMember(userResponse.getId())) {
            String token = provider.createToken(userResponse.getId());
            return CheckUserResult.builder()
                    .kakaoId(userResponse.getId())
                    .isJoined(true)
                    .nickname(userResponse.getKakaoAccount().getName())
                    .token(token)
                    .build();
        }

        return CheckUserResult.builder()
                .kakaoId(userResponse.getId())
                .nickname(userResponse.getKakaoAccount().getName())
                .isJoined(false)
                .build();
    }
}
