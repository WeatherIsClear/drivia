package weather.clear.drivia.domain.drivingjoin.repository;

import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

import java.util.List;

public interface DrivingJoinRepositoryCustom {

    List<DrivingJoin> findWithDrivingDriver(Driving driving);
}
