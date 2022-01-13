package weather.clear.drivia.domain.driving;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.clear.drivia.domain.car.Car;
import weather.clear.drivia.domain.car.CarRepository;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;
import weather.clear.drivia.domain.carmodel.CarModel;
import weather.clear.drivia.domain.carmodel.CarModelRepository;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.drivingjoin.DrivingJoinRepository;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;
import weather.clear.drivia.domain.member.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.*;

@ExtendWith(MockitoExtension.class)
class DrivingServiceTest {

    @Mock
    CarRepository carRepository;

    @Mock
    MemberRepository memberRepository;

    @Mock
    DrivingRepository drivingRepository;

    @Mock
    CarModelRepository carModelRepository;

    @Mock
    DrivingJoinRepository drivingJoinRepository;


    MemberSignUpDto memberDto;
    RegistrationCarDto carDto;
    CreatDrivingDto drivingDto;
    Member member;
    Car car;
    CarModel carModel;
    Driving driving;
    DrivingJoin drivingJoin;

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

        carDto = RegistrationCarDto.builder()
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
                .totalHeadCount(4)
                .build();

        member = Member.of(memberDto);
        carModel = new CarModel("아반떼 XD", "현대", "www");
        car = Car.of(member, carModel, carDto);
        driving = Driving.of(member, car, drivingDto);
        drivingJoin = DrivingJoin.of(member, driving);
    }
    @Test
    void createDriving() {
        given(memberRepository.findById(1L)).willReturn(ofNullable(member));

        given(carModelRepository.findById(carDto.getCarModelId())).willReturn(of(carModel));

        given(carRepository.findById(3L)).willReturn(ofNullable(car));

        given(drivingRepository.save(driving)).willReturn(driving);

        Member findMember = memberRepository.findById(1L).get();
        CarModel findCarModel = carModelRepository.findById(2L).get();
        Car findCar = carRepository.findById(3L).get();
        Driving savedDriving = drivingRepository.save(driving);

        assertThat(findMember.getUsername()).isEqualTo("김동영");
        assertThat(findCarModel).isEqualTo(carModel);
        assertThat(findCar).isEqualTo(car);
        assertThat(savedDriving).isEqualTo(driving);
    }

    @Test
    void drivingInfo() {
        given(drivingRepository.drivingDetails(1L)).willReturn(driving);
        Driving findDriving = drivingRepository.drivingDetails(1L);

        List<DrivingJoin> list = new ArrayList<>();
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

        given(drivingJoinRepository.findByDriving(driving)).willReturn(list);
        List<DrivingJoin> drivingJoins = drivingJoinRepository.findByDriving(driving);

        int nowHeadCount = driving.drivingJoinCount(drivingJoins, JOIN).intValue();
        int waitingJoinCount = driving.drivingJoinCount(drivingJoins, WAITING).intValue();

        assertThat(drivingJoins.size()).isEqualTo(10);
        assertThat(nowHeadCount).isEqualTo(4);
        assertThat(waitingJoinCount).isEqualTo(6);
    }

}