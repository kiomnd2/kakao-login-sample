package com.sample.infrastructure.member.kakao;

import com.sample.domain.member.kakao.KakaoUserResponse;
import com.sample.domain.member.kakao.UserInfoRequestCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class UserInfoRequestCallerImpl implements UserInfoRequestCaller {
    private static final String KAKAO_USERINFO_REQUEST_URL = "https://kapi.kakao.com";

    @Override
    public KakaoUserResponse call(String accessToken) {
        KakaoUserResponse response = WebClient.create(KAKAO_USERINFO_REQUEST_URL).post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .path("/v2/user/me")
                        .build(true))
                .header(HttpHeaders.CONTENT_TYPE, "HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString()")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .onStatus(HttpStatusCode::is3xxRedirection, clientResponse -> Mono.error(new RuntimeException("3xx error")))
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx error")))
                .bodyToMono(KakaoUserResponse.class).block();
        return response;
    }
}
