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

    @GetMapping("/callback")
    public CommonResponse<KakaoMemberDto.AccessTokenResponse> loginCallback(@RequestParam(required = false) String code, @RequestParam(required = false) String state,
                                                                     @RequestParam(required = false) String error, @RequestParam(required = false) String error_description) {
        if (!StringUtils.isEmpty(error)) {
            return CommonResponse.failed(error, error_description);
        }
        return CommonResponse.success(KakaoMemberDto.AccessTokenResponse
                .builder()
                .accessToken(memberLoginService.getAccessToken(code))
                .build());
    }

    @PostMapping("/auth-check")
    public CommonResponse<KakaoMemberDto.LoginResponse> authCheck(@RequestHeader("X-AUTH-KEY") String accessToken) {
        CheckUserResult checkMember = memberLoginService.getCheckMember(accessToken);
        return CommonResponse.success(KakaoMemberDto.LoginResponse.builder()
                        .kakaoId(checkMember.kakaoId())
                        .token(checkMember.token())
                        .isJoined(checkMember.isJoined())
                        .nickname(checkMember.nickname())
                .build());
    }
}
