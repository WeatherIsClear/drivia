package weather.clear.drivia.domain.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Gender;
import weather.clear.drivia.domain.member.entity.Member;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;

    @Test
    void checkDuplicateEmail() {

        MemberSignUpDto dto = MemberSignUpDto.builder()
                .username("김동영")
                .password("1234")
                .email("yeongdonge@gmail.com")
                .birth(LocalDate.of(1998, 2, 9))
                .nickname("yeongdonge")
                .gender(1)
                .phone("01012341256")
                .build();

        Member member = Member.of(dto);

        given(memberRepository.existsByEmail(member.getEmail())).willReturn(false);

        boolean result = memberRepository.existsByEmail(member.getEmail());
        assertThat(result).isFalse();
    }

    @Test
    void save() {
        MemberSignUpDto dto = MemberSignUpDto.builder()
                .username("김동영")
                .password("1234")
                .email("yeongdonge@gmail.com")
                .birth(LocalDate.of(1998, 2, 9))
                .nickname("yeongdonge")
                .gender(1)
                .phone("01012341256")
                .build();

        Member member = Member.of(dto);

        given(memberRepository.save(member)).willReturn(member);

        Member savedMember = memberRepository.save(member);
        assertThat(savedMember).isEqualTo(member);
    }
}