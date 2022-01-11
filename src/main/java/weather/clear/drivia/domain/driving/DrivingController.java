package weather.clear.drivia.domain.driving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DrivingController {

    private final DrivingService drivingService;

    @PostMapping("/driving/{memberId}")
    public void createDriving(@PathVariable Long memberId, @RequestBody CreatDrivingDto request) {
        drivingService.createDriving(memberId, request);
    }

}
