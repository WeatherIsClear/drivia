package weather.clear.drivia.domain.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;
import weather.clear.drivia.domain.driving.DrivingService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/car/{memberId}")
    public void registrationCar(@PathVariable Long memberId, @RequestBody RegistrationCarDto request) {
        carService.registrationCar(memberId, request);
    }
}
