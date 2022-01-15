package weather.clear.drivia.domain.drivingjoin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather.clear.drivia.domain.drivingjoin.dto.DrivingJoinRequestDto;
import weather.clear.drivia.domain.drivingjoin.dto.DrivingJoinResponseDto;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DrivingJoinController {

    private final DrivingJoinService drivingJoinService;

    @PostMapping("/driving-join")
    public void drivingJoinRequest(@RequestBody DrivingJoinRequestDto request) {
        drivingJoinService.drivingJoinRequest(request);
    }

    @PatchMapping("/driving-join")
    public void drivingJoinResponse(@RequestBody DrivingJoinResponseDto request) {
        drivingJoinService.drivingJoinResponse(request);
    }
}
