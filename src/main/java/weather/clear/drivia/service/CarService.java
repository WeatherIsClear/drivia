package weather.clear.drivia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.repository.CarRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
}
