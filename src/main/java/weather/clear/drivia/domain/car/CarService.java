package weather.clear.drivia.domain.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.entity.Member;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final MemberRepository memberRepository;

    public void registrationCar(Long memberId, RegistrationCarDto request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 회원입니다."));

        Car car = Car.of(member, request);
        carRepository.save(car);
    }
}
