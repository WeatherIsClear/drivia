package weather.clear.drivia.domain.driving;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.clear.drivia.domain.car.Car;
import weather.clear.drivia.domain.car.CarRepository;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Optional.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class DrivingServiceTest {

    @Mock
    CarRepository carRepository;

    @Mock
    MemberRepository memberRepository;

    @Mock
    DrivingRepository drivingRepository;

    @Test
    void createDriving() {
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

        given(memberRepository.findById(1L)).willReturn(ofNullable(member));

        RegistrationCarDto carDto = RegistrationCarDto.builder()
                .carNumber("서울30가0000")
                .RegistrationDate(LocalDate.of(2021, 1, 1))
                .carName("아반떼XD")
                .vendor("현대")
                .imgUrl(null)
                .build();

        Car car = Car.of(member, carDto);

        given(carRepository.findById(2L)).willReturn(ofNullable(car));

        CreatDrivingDto drivingDto = CreatDrivingDto.builder()
                .carId(2L)
                .departDateTime(LocalDateTime.of(2022, 1, 12, 12, 0))
                .departLocation("서울시 광진구 화양동 동일로28길")
                .destination("대구광역시 달성군 다사읍 서재로120")
                .build();

        Driving driving = Driving.of(member, car, drivingDto);
        given(drivingRepository.save(driving)).willReturn(driving);

        Member findMember = memberRepository.findById(1L).get();
        Car findCar = carRepository.findById(2L).get();
        driving.expectedTimeCalc(driving);
        Driving savedDriving = drivingRepository.save(driving);

        assertThat(findMember).isEqualTo(member);
        assertThat(findCar).isEqualTo(car);
        assertThat(driving.getExpectedTime()).isEqualTo(driving.getDepartDateTime());
        assertThat(savedDriving).isEqualTo(driving);

    }

}