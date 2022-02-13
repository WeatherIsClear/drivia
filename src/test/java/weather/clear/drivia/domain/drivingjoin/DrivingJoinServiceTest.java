package weather.clear.drivia.domain.drivingjoin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.clear.drivia.domain.car.Car;
import weather.clear.drivia.domain.car.dto.CarRegistrationDto;
import weather.clear.drivia.domain.carmodel.CarModel;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;
import weather.clear.drivia.domain.drivingjoin.repository.DrivingJoinRepository;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Optional.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.JOINED;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.WAITING;

@ExtendWith(MockitoExtension.class)
class DrivingJoinServiceTest {

    @Mock
    MemberRepository memberRepository;
    @Mock
    DrivingRepository drivingRepository;
    @Mock
    DrivingJoinRepository drivingJoinRepository;

    MemberSignUpDto memberDto;
    CarRegistrationDto carDto;
    CreatDrivingDto drivingDto;
    Member member;
    Car car;
    CarModel carModel;
    Driving driving;

    @BeforeEach
    void initData() {
        memberDto = MemberSignUpDto.builder()
                .username("김동영")
                .password("1234")
                .email("yeongdonge@gmail.com")
                .birth(LocalDate.of(1998, 2, 9))
                .nickname("yeongdonge")
                .gender(1)
                .phone("01012341256")
                .build();

        carDto = CarRegistrationDto.builder()
                .memberId(1L)
                .carModelId(2L)
                .carNumber("서울30가0000")
                .registrationDate(LocalDate.of(2021, 1, 1))
                .build();

        drivingDto = CreatDrivingDto.builder()
                .memberId(1L)
                .carId(3L)
                .departDateTime(LocalDateTime.of(2022, 1, 12, 12, 0))
                .departLocation("서울시 광진구 화양동 동일로28길")
                .destination("대구광역시 달성군 다사읍 서재로120")
                .maximumDriver(4)
                .build();

        member = Member.of(memberDto);
        carModel = new CarModel("아반떼 XD", "현대", "www");
        car = Car.of(member, carModel, carDto);
        driving = Driving.of(member, car, drivingDto);
    }

    @Test
    void drivingJoinRequest() {
        given(memberRepository.findById(1L)).willReturn(ofNullable(member));
        given(drivingRepository.findById(2L)).willReturn(ofNullable(driving));

        Member findMember = memberRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Driving findDriving = drivingRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 드라이빙입니다."));
        DrivingJoin drivingJoin = DrivingJoin.of(findMember, findDriving);

        given(drivingJoinRepository.save(drivingJoin)).willReturn(drivingJoin);
        DrivingJoin savedDrivingJoin = drivingJoinRepository.save(drivingJoin);

        assertThat(findMember).isEqualTo(member);
        assertThat(findDriving).isEqualTo(driving);
        assertThat(savedDrivingJoin).isEqualTo(drivingJoin);
    }

    @Test
    void drivingJoinResponse() {
        DrivingJoin drivingJoin = DrivingJoin.of(member, driving);
        given(drivingJoinRepository.findById(1L)).willReturn(ofNullable(drivingJoin));

        DrivingJoin findDrivingJoin = drivingJoinRepository.findById(1L).orElseThrow(
                () -> new IllegalArgumentException("조인 요청을 취소하였습니다."));

        assertThat(findDrivingJoin.getStatus()).isEqualTo(WAITING);
        findDrivingJoin.joinResult(JOINED);
        assertThat(findDrivingJoin.getStatus()).isEqualTo(JOINED);
    }
}