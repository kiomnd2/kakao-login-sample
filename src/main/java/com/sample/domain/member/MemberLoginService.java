package com.sample.domain.member;

import com.sample.domain.member.kakao.AccessTokenRequestResult;

public interface MemberLoginService {
    AccessTokenRequestResult getAccessToken(String loginCallbackCode);
}
