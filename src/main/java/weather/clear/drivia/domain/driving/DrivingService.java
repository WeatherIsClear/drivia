package weather.clear.drivia.domain.driving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.car.Car;
import weather.clear.drivia.domain.car.CarRepository;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.dto.DriverDrivingDetailsDto;
import weather.clear.drivia.domain.driving.dto.JoinDriverDto;
import weather.clear.drivia.domain.driving.dto.OwnerDrivingDetailsDto;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.drivingjoin.DrivingJoinRepository;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.entity.Member;

import java.util.List;

import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DrivingService {

    private final CarRepository carRepository;
    private final MemberRepository memberRepository;
    private final DrivingRepository drivingRepository;
    private final DrivingJoinRepository drivingJoinRepository;

    public void createDriving(CreatDrivingDto request) {

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원 입니다."));

        Car car = carRepository.findById(request.getCarId()).orElseThrow(
                () -> new IllegalArgumentException("차량이 등록되지 않았습니다."));

        Driving driving = Driving.of(member, car, request);

        drivingRepository.save(driving);
    }

    public DriverDrivingDetailsDto driverDrivingDetails(Long drivingId) {
        Driving driving = drivingRepository.drivingDetails(drivingId);

        List<DrivingJoin> drivingJoins = drivingJoinRepository.findByDriving(driving);

        int nowHeadCount = driving.drivingJoinCount(drivingJoins, JOIN).intValue();
        int waitingJoinCount = driving.drivingJoinCount(drivingJoins, WAITING).intValue();

        //나와의 거리

       return DriverDrivingDetailsDto.of(driving, nowHeadCount, waitingJoinCount, 1);
    }

    public OwnerDrivingDetailsDto ownerDrivingDetails(Long drivingId) {
        Driving driving = drivingRepository.drivingDetails(drivingId);

        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(driving);

        List<JoinDriverDto> joinedDrivers = driving.joinDrivers(drivingJoins, JOIN);
        List<JoinDriverDto> waitingDrivers = driving.joinDrivers(drivingJoins, WAITING);

        return OwnerDrivingDetailsDto.of(driving, joinedDrivers, waitingDrivers);
    }
}
