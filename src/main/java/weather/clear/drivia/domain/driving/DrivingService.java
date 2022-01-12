package weather.clear.drivia.domain.driving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.car.Car;
import weather.clear.drivia.domain.car.CarRepository;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.dto.DrivingInfoDto;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.entity.Member;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DrivingService {

    private final CarRepository carRepository;
    private final MemberRepository memberRepository;
    private final DrivingRepository drivingRepository;

    public void createDriving(Long memberId, CreatDrivingDto dto) {

        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원 입니다."));

        Car car = carRepository.findById(dto.getCarId()).orElseThrow(
                () -> new IllegalArgumentException("차량이 등록되지 않았습니다."));

        Driving driving = Driving.of(member, car, dto);

        drivingRepository.save(driving);
    }

    public DrivingInfoDto drivingInfo(Long drivingId) {
        return drivingRepository.drivingInfo(drivingId);
    }
}
