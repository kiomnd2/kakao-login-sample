# 카카오 로그인 샘플

![img.png](img%2Fimg.png)

1. 클라이언트 -> 서버 카카로 로그인 요청
2. 서버 -> 카카오 인증센터로 인가요청코드 리턴
3. 리턴받은 인가 코드를 이용해 Accesscode 요청
4. 리턴 받은 Accesscode를 이용해 사용자 조회, id 조회
5. id DB에 저장되어 있으면 Jwt 토큰 발급
6. 없으면 회원가입 페이지로 이동