package weather.clear.drivia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.repository.InsuranceRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
}
