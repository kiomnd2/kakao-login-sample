package com.sample.interfaces.kakao;

import com.sample.common.response.CommonResponse;
import com.sample.domain.member.MemberLoginService;
import com.sample.domain.member.kakao.CheckUserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kakao")
public class KakaoMemberLoginApi {
    private final MemberLoginService memberLoginService;

    @PostMapping("/auth-check")
    public CommonResponse<KakaoMemberDto.LoginResponse> authCheck(@RequestHeader String accessToken) {
        CheckUserResult checkMember = memberLoginService.getCheckMember(accessToken);
        return CommonResponse.success(KakaoMemberDto.LoginResponse.builder()
                        .kakaoId(checkMember.kakaoId())
                        .token(checkMember.token())
                        .isJoined(checkMember.isJoined())
                        .nickname(checkMember.nickname())
                .build());
    }
}
