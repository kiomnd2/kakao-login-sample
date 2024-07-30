package com.sample.domain.member.kakao;

public interface UserInfoRequestCaller {
    KakaoUserResponse call(String accessToken);
}
