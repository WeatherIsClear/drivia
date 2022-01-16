package weather.clear.drivia.domain.driving;

import lombok.AllArgsConstructor;
import lombok.Builder;
import weather.clear.drivia.domain.driving.dto.JoinDriverDto;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
public class JoinDriverDrivingDetailsDto {

    private Long drivingId;
    private Long ownerId;
    private String nickname;
    private String profilePicture;
    private String carPicture;
    private int countOfJoinedDrivers;
    private int countOfMaximumDrivers;
    private String myJoinStatus;
    private LocalDateTime departDateTime;
    private String departLocation;
    private String destination;
    private LocalDateTime expectedTime;
    private List<JoinDriverDto> joinedDrivers;

    public static JoinDriverDrivingDetailsDto of(Driving driving,
                                             List<JoinDriverDto> joinedDrivers, String myJoinStatus) {
        return JoinDriverDrivingDetailsDto.builder()
                .drivingId(driving.getId())
                .ownerId(driving.getMember().getId())
                .nickname(driving.getMember().getNickname())
                .profilePicture(driving.getMember().getImgUrl())
                .carPicture(driving.getCar().getCarModel().getImageUrl())
                .countOfJoinedDrivers(joinedDrivers.size())
                .countOfMaximumDrivers(driving.getMaximumDriver())
                .myJoinStatus(myJoinStatus)
                .departDateTime(driving.getDepartDateTime())
                .departLocation(driving.getDepartLocation())
                .destination(driving.getDestination())
                .expectedTime(driving.getExpectedTime())
                .joinedDrivers(joinedDrivers)
                .build();
    }
}
