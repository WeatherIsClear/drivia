package weather.clear.drivia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.repository.DriverRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
}
