package weather.clear.drivia.domain.driving;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.driving.dto.DrivingDetailsDto;
import weather.clear.drivia.domain.driving.dto.OwnerDrivingDetailsDto;
import weather.clear.drivia.domain.driving.service.DrivingQueryService;
import weather.clear.drivia.domain.driving.service.DrivingService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DrivingController {

    private final DrivingService drivingService;
    private final DrivingQueryService drivingQueryService;

    @PostMapping("/driving")
    public void createDriving(@RequestBody CreatDrivingDto request) {
        drivingService.createDriving(request);
    }

    @GetMapping("/driving/{drivingId}")
    public DrivingDetailsDto drivingDetails(@PathVariable Long drivingId) {
        return drivingQueryService.drivingDetails(drivingId);
    }

    @GetMapping("/driver/driving/{driverId}/{drivingId}")
    public JoinDriverDrivingDetailsDto joinDriverDrivingDetails(@PathVariable Long driverId, @PathVariable Long drivingId) {
        return drivingQueryService.joinDriverDrivingDetails(driverId, drivingId);
    }

    @GetMapping("/owner/driving/{drivingId}")
    public OwnerDrivingDetailsDto ownerDrivingDetails(@PathVariable Long drivingId) {
        return drivingQueryService.ownerDrivingDetails(drivingId);
    }
}
