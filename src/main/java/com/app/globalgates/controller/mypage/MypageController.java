package com.app.globalgates.controller.mypage;

import com.app.globalgates.auth.JwtTokenProvider;
import com.app.globalgates.dto.MemberDTO;
import com.app.globalgates.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage/**")
public class MypageController {
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;

    @GetMapping("/mypage")
    public String goToMypage(HttpServletRequest request, Model model) {
        // 메인 페이지와 같은 방식으로 로그인 토큰에서 사용자 식별자를 꺼낸다.
        // 이렇게 해야 템플릿이 현재 로그인 회원 기준으로 이름/핸들을 렌더링할 수 있다.
        String token = jwtTokenProvider.parseTokenFromHeader(request);
        String loginId = jwtTokenProvider.getUsername(token);
        MemberDTO member = memberService.getMember(loginId);

        // mypage 템플릿에서는 member 모델 하나만 사용해서 이름/핸들을 출력한다.
        model.addAttribute("member", member);
        return "mypage/mypage";
    }
}
