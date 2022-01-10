package weather.clear.drivia.domain.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Member;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @Mock
    MemberRepository memberRepository;

    @Test
    void registrationCar() {

        MemberSignUpDto memberDto = MemberSignUpDto.builder()
                .username("김동영")
                .password("1234")
                .email("yeongdonge@gmail.com")
                .birth(LocalDate.of(1998, 2, 9))
                .nickname("yeongdonge")
                .gender(1)
                .phone("01012341256")
                .build();

        Member member = Member.of(memberDto);

        given(memberRepository.findById(1L)).willReturn(Optional.ofNullable(member));


        RegistrationCarDto carDto = RegistrationCarDto.builder()
                .carNumber("서울30가0000")
                .RegistrationDate(LocalDate.of(2021, 1, 1))
                .carName("아반떼XD")
                .vendor("현대")
                .imgUrl(null)
                .build();
        Car car = Car.of(member, carDto);

        given(carRepository.save(car)).willReturn(car);

        Member findMember = memberRepository.findById(1L).get();
        Car savedCar = carRepository.save(car);

        assertThat(findMember).isEqualTo(member);
        assertThat(savedCar).isEqualTo(car);
    }

}