package weather.clear.drivia.domain.driving;

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

    @Mock
    CarModelRepository carModelRepository;

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
                .carModelId(2L)
                .carNumber("서울30가0000")
                .RegistrationDate(LocalDate.of(2021, 1, 1))
                .build();

        CarModel carModel = new CarModel("", "", "");
        given(carModelRepository.findById(carDto.getCarModelId())).willReturn(of(carModel));

        Car car = Car.of(member, carModel, carDto);

        given(carRepository.findById(3L)).willReturn(ofNullable(car));

        CreatDrivingDto drivingDto = CreatDrivingDto.builder()
                .carId(3L)
                .departDateTime(LocalDateTime.of(2022, 1, 12, 12, 0))
                .departLocation("서울시 광진구 화양동 동일로28길")
                .destination("대구광역시 달성군 다사읍 서재로120")
                .totalHeadCount(4)
                .build();

        Driving driving = Driving.of(member, car, drivingDto);
        given(drivingRepository.save(driving)).willReturn(driving);

        Member findMember = memberRepository.findById(1L).get();
        CarModel findCarModel = carModelRepository.findById(2L).get();
        Car findCar = carRepository.findById(3L).get();
        Driving savedDriving = drivingRepository.save(driving);

        assertThat(findMember).isEqualTo(member);
        assertThat(findCarModel).isEqualTo(carModel);
        assertThat(findCar).isEqualTo(car);
        assertThat(savedDriving).isEqualTo(driving);

    }

}