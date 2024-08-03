package com.sample.interfaces.kakao;

import com.sample.common.response.CommonResponse;
import com.sample.domain.member.MemberLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@RequiredArgsConstructor
@Controller
@RequestMapping("kakao")
public class KakaoCallbackController {
    private final MemberLoginService memberLoginService;

    @GetMapping("/callback")
    public String loginCallback(@RequestParam(required = false) String code, @RequestParam(required = false) String state,
                                                                            @RequestParam(required = false) String error, @RequestParam(required = false) String error_description) {
        if (!StringUtils.isEmpty(error)) {
            // TODO Throw Error
        }
        return "redirect:http://localhost:8080/kakao/test?accessToken=" + memberLoginService.getAccessToken(code);
    }
    @GetMapping("/test")
    public String test(@RequestParam("accessToken") String accessToken) {
        System.out.println(accessToken);
        return "test";
    }

}
