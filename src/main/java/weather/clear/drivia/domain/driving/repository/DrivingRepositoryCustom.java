package weather.clear.drivia.domain.driving.repository;

import weather.clear.drivia.domain.driving.dto.DrivingInfoDto;

public interface DrivingRepositoryCustom {

    DrivingInfoDto drivingInfo(Long drivingId);
}
