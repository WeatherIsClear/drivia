package weather.clear.drivia.domain.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;
import weather.clear.drivia.domain.carmodel.CarModel;
import weather.clear.drivia.domain.carmodel.CarModelRepository;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.entity.Member;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final MemberRepository memberRepository;
    private final CarModelRepository carModelRepository;

    public void registrationCar(RegistrationCarDto request) {

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        CarModel carModel = carModelRepository.findById(request.getCarModelId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 모델입니다."));

        Car car = Car.of(member, carModel, request);
        carRepository.save(car);
    }
}
