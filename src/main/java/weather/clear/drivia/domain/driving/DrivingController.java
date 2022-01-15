package weather.clear.drivia.domain.driving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.dto.DriverDrivingDetailsDto;
import weather.clear.drivia.domain.driving.dto.OwnerDrivingDetailsDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DrivingController {

    private final DrivingService drivingService;

    @PostMapping("/driving")
    public void createDriving(@RequestBody CreatDrivingDto request) {
        drivingService.createDriving(request);
    }

    @GetMapping("/driver/driving/{drivingId}")
    public DriverDrivingDetailsDto driverDrivingDetails(@PathVariable Long drivingId) {
        return drivingService.driverDrivingDetails(drivingId);
    }

    @GetMapping("/owner/driving/{drivingId}")
    public OwnerDrivingDetailsDto ownerDrivingDetails(@PathVariable Long drivingId) {
        return drivingService.ownerDrivingDetails(drivingId);
    }
}
