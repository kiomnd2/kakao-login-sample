package com.sample.interfaces.kakao;

import com.sample.domain.member.MemberLoginService;
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
    public KakaoMemberDto.LoginResponse loginCallback(@RequestParam(required = false) String code, @RequestParam(required = false) String state,
            @RequestParam(required = false) String error, @RequestParam(required = false) String error_description) {
        String token = memberLoginService.getAccessToken(code);
        return KakaoMemberDto.LoginResponse.builder()
                .token(token)
                .isError(false)
                .build();
    }

}
