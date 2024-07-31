package com.sample.interfaces.kakao;

import com.sample.common.response.CommonResponse;
import com.sample.domain.member.MemberLoginService;
import com.sample.domain.member.kakao.AccessTokenRequestResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kakao")
public class KakaoMemberLoginApi {
    private final MemberLoginService memberLoginService;

    @GetMapping("/callback")
    public CommonResponse<KakaoMemberDto.LoginResponse> loginCallback(@RequestParam(required = false) String code, @RequestParam(required = false) String state,
                                                                     @RequestParam(required = false) String error, @RequestParam(required = false) String error_description) {
        if (!StringUtils.isEmpty(error)) {
            return CommonResponse.failed(error, error_description);
        }

        AccessTokenRequestResult result = memberLoginService.getAccessToken(code);
        return CommonResponse.success(KakaoMemberDto.LoginResponse.builder()
                        .isJoined(result.isJoined())
                        .kakaoId(result.kakaoId())
                        .token(result.token())
                        .nickname(result.nickname())
                .build());
    }

}
