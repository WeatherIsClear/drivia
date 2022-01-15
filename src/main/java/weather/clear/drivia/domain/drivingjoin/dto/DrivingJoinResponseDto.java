package weather.clear.drivia.domain.drivingjoin.dto;

import lombok.Getter;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus;

@Getter
public class DrivingJoinResponseDto {

    private Long drivingJoinId;
    private DrivingJoinStatus status;
}
