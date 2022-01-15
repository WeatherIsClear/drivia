package weather.clear.drivia.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void signup(@RequestBody MemberSignUpDto request) {
        memberService.save(request);
    }
}
