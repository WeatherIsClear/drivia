package weather.clear.drivia.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Member;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberSignUpDto memberSignUpDto) {

        checkDuplicateEmail(memberSignUpDto);

        Member member = Member.of(memberSignUpDto);
        memberRepository.save(member);
    }

    private void checkDuplicateEmail(MemberSignUpDto memberSignUpDto) {
        if (memberRepository.existsByEmail(memberSignUpDto.getEmail())) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
