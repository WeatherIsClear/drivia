package weather.clear.drivia.domain.driving.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.driving.JoinDriverDrivingDetailsDto;
import weather.clear.drivia.domain.driving.dto.DrivingDetailsDto;
import weather.clear.drivia.domain.driving.dto.JoinDriverDto;
import weather.clear.drivia.domain.driving.dto.OwnerDrivingDetailsDto;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus;
import weather.clear.drivia.domain.drivingjoin.repository.DrivingJoinRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.JOINED;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.WAITING;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DrivingQueryService {

    private final DrivingRepository drivingRepository;
    private final DrivingJoinRepository drivingJoinRepository;

    public DrivingDetailsDto drivingDetails(Long drivingId) {

        Driving driving = drivingRepository.drivingDetails(drivingId);

        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(driving);

        List<JoinDriverDto> joinedDrivers = drivingJoinToJoinDriverDto(drivingJoins, JOINED);
        long countOfWaitingDrivers = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(WAITING)).count();

        return DrivingDetailsDto.of(driving, joinedDrivers, (int) countOfWaitingDrivers);
    }

    public JoinDriverDrivingDetailsDto joinDriverDrivingDetails(Long driverId, Long drivingId) {

        Driving driving = drivingRepository.drivingDetails(drivingId);

        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(driving);

        List<JoinDriverDto> joinedDrivers = drivingJoinToJoinDriverDto(drivingJoins, JOINED);
        String myJoinStatus = drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getMember().getId().equals(driverId))
                .findAny().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."))
                .getStatus().getJoinStatus();

        return JoinDriverDrivingDetailsDto.of(driving, joinedDrivers, myJoinStatus);
    }

    public OwnerDrivingDetailsDto ownerDrivingDetails(Long drivingId) {

        Driving driving = drivingRepository.drivingDetails(drivingId);

        List<DrivingJoin> drivingJoins = drivingJoinRepository.findWithDrivingDriver(driving);

        List<JoinDriverDto> joinedDrivers = drivingJoinToJoinDriverDto(drivingJoins, JOINED);
        List<JoinDriverDto> waitingDrivers = drivingJoinToJoinDriverDto(drivingJoins, WAITING);

        return OwnerDrivingDetailsDto.of(driving, joinedDrivers, waitingDrivers);
    }

    private List<JoinDriverDto> drivingJoinToJoinDriverDto(List<DrivingJoin> drivingJoins, DrivingJoinStatus status) {
        return drivingJoins.stream()
                .filter(drivingJoin -> drivingJoin.getStatus().equals(status))
                .map(JoinDriverDto::new).collect(toList());
    }
}
