package weather.clear.drivia.domain.driving.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import weather.clear.drivia.domain.driving.Driving;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
public class DriverDrivingDetailsDto {

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
    private int kmFromMe;

    public static DriverDrivingDetailsDto of(Driving driving,
                                             List<JoinDriverDto> joinedDrivers, int countOfWaitingDrivers,
                                             int kmFromMe) {
        return DriverDrivingDetailsDto.builder()
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
                .kmFromMe(kmFromMe)
                .build();
    }
}
