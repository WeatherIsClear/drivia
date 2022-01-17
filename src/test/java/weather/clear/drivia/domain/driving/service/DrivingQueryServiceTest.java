package weather.clear.drivia.domain.driving.service;

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
import weather.clear.drivia.domain.driving.dto.JoinDriverDto;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;
import weather.clear.drivia.domain.drivingjoin.repository.DrivingJoinRepository;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.JOINED;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.WAITING;

@ExtendWith(MockitoExtension.class)
class DrivingQueryServiceTest {

    @Mock
    DrivingJoinRepository drivingJoinRepository;

    @Mock
    DrivingRepository drivingRepository;

    @Mock
    MemberRepository memberRepository;

    MemberSignUpDto memberDto;
    CarRegistrationDto carDto;
    CreatDrivingDto drivingDto;
    Member member;
    Car car;
    CarModel carModel;
    Driving driving;
    DrivingJoin drivingJoin;
    List<DrivingJoin> list = new ArrayList<>();

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
                .RegistrationDate(LocalDate.of(2021, 1, 1))
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
        drivingJoin = DrivingJoin.of(member, driving);
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
        list.add(DrivingJoin.of(member, driving));
    }

    @Test
    void drivingDetails() {
        given(drivingRepository.drivingDetails(1L)).willReturn(driving);
        Driving findDriving = drivingRepository.drivingDetails(1L);

        given(drivingJoinRepository.findWithDrivingDriver(findDriving)).willReturn(list);
        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(findDriving);

        List<JoinDriverDto> joinedDrivers = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(JOINED))
                .map(JoinDriverDto::new).collect(toList());

        long countOfWaitingDrivers = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(WAITING)).count();

        assertThat(joinedDrivers.size()).isEqualTo(0);
        assertThat(countOfWaitingDrivers).isEqualTo(10);
        assertThat(findDriving).isEqualTo(driving);
        assertThat(drivingJoins).isEqualTo(list);
    }

    @Test
    void joinDriverDrivingDetails() {
        given(drivingRepository.drivingDetails(1L)).willReturn(driving);
        Driving findDriving = drivingRepository.drivingDetails(1L);

        given(drivingJoinRepository.findWithDrivingDriver(findDriving)).willReturn(list);
        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(findDriving);

        List<JoinDriverDto> joinDrivers = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(JOINED))
                .map(JoinDriverDto::new).collect(toList());

        given(memberRepository.findById(1L)).willReturn(ofNullable(member));
        Member findMember = memberRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        String myJoinStatus = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getMember().equals(findMember))
                .findAny().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."))
                .getStatus().getJoinStatus();

        assertThat(findDriving).isEqualTo(driving);
        assertThat(drivingJoins.size()).isEqualTo(10);
        assertThat(drivingJoins).isEqualTo(list);
        assertThat(joinDrivers.size()).isEqualTo(0);
        assertThat(myJoinStatus).isEqualTo(WAITING.getJoinStatus());
    }

    @Test
    void ownerDrivingDetails() {
        given(drivingRepository.drivingDetails(1L)).willReturn(driving);
        Driving findDriving = drivingRepository.drivingDetails(1L);

        given(drivingJoinRepository.findWithDrivingDriver(findDriving)).willReturn(list);
        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(findDriving);

        List<JoinDriverDto> joinedDrivers = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(JOINED))
                .map(JoinDriverDto::new).collect(toList());
        List<JoinDriverDto> waitingDrivers = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(WAITING))
                .map(JoinDriverDto::new).collect(toList());

        assertThat(findDriving).isEqualTo(driving);
        assertThat(drivingJoins).isEqualTo(list);
        assertThat(joinedDrivers.size()).isEqualTo(0);
        assertThat(waitingDrivers.size()).isEqualTo(10);
    }

}