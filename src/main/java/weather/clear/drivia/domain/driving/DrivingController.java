package weather.clear.drivia.domain.driving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.dto.DrivingInfoDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DrivingController {

    private final DrivingService drivingService;

    @PostMapping("/driving")
    public void createDriving(@RequestBody CreatDrivingDto request) {
        drivingService.createDriving(request);
    }

    @GetMapping("/driving/{drivingId}")
    public DrivingInfoDto drivingInfo(@PathVariable Long drivingId) {
        return drivingService.drivingInfo(drivingId);
    }
}
