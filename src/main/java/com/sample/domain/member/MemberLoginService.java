package com.sample.domain.member;

import com.sample.domain.member.kakao.CheckUserResult;

public interface MemberLoginService {
    String getAccessToken(String loginCallbackCode);

    CheckUserResult getCheckMember(String accessToken);
}
