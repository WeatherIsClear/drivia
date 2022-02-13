package weather.clear.drivia.domain.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather.clear.drivia.domain.car.dto.CarRegistrationDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/car")
    public void carRegistration(@RequestBody CarRegistrationDto request) {
        carService.carRegistration(request);
    }
}
