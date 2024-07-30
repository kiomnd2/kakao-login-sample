package com.sample.domain.member.kakao;

import java.util.Optional;

public interface TokenRequestCaller {
    Optional<KakaoTokenResponse> call(String code);
}
