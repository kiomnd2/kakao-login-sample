package com.sample.domain.member.kakao;

import java.util.Optional;

public interface TokenRequestCaller {
    KakaoTokenResponse call(String code);
}
