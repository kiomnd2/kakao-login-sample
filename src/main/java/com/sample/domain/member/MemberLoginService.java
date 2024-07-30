package com.sample.domain.member;

public interface MemberLoginService {
    String getAccessToken(String LoginCallbackCode);
}
