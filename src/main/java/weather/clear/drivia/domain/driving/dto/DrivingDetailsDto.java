package weather.clear.drivia.domain.driving.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import weather.clear.drivia.domain.driving.Driving;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
public class DrivingDetailsDto {

    private Long drivingId;
    private Long ownerId;
    private String nickname;
    private String profilePicture;
    private String carPicture;
    private int countOfJoinedDrivers;
    private int countOfMaximumDrivers;
    private int countOfWaitingDrivers;
    private LocalDateTime departDateTime;
    private String departLocation;
    private String destination;
    private LocalDateTime expectedTime;
    private List<JoinDriverDto> joinedDrivers;

    public static DrivingDetailsDto of(Driving driving,
                                       List<JoinDriverDto> joinedDrivers, int countOfWaitingDrivers) {
        return DrivingDetailsDto.builder()
                .drivingId(driving.getId())
                .ownerId(driving.getMember().getId())
                .nickname(driving.getMember().getNickname())
                .profilePicture(driving.getMember().getImgUrl())
                .carPicture(driving.getCar().getCarModel().getImageUrl())
                .countOfJoinedDrivers(joinedDrivers.size())
                .countOfMaximumDrivers(driving.getMaximumDriver())
                .countOfWaitingDrivers(countOfWaitingDrivers)
                .departDateTime(driving.getDepartDateTime())
                .departLocation(driving.getDepartLocation())
                .destination(driving.getDestination())
                .expectedTime(driving.getExpectedTime())
                .joinedDrivers(joinedDrivers)
                .build();
    }
}
