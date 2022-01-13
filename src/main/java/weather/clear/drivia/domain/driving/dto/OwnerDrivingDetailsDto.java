package weather.clear.drivia.domain.driving.dto;

import lombok.Builder;
import weather.clear.drivia.domain.driving.Driving;

import java.time.LocalDateTime;
import java.util.List;

public class OwnerDrivingDetailsDto {

    private String nickname;
    private String profilePicture;
    private String carPicture;
    private int nowHeadCount;
    private int totalHeadCount;
    private int waitingJoinCount;
    private LocalDateTime departDateTime;
    private String departLocation;
    private String destination;
    private LocalDateTime expectedTime;
    private List<JoinDriverDto> joinDrivers;
    private List<JoinDriverDto> waitingDrivers;

    @Builder
    private OwnerDrivingDetailsDto(String nickname, String profilePicture, String carPicture,
                                    int nowHeadCount, int totalHeadCount, int waitingJoinCount,
                                    LocalDateTime departDateTime, String departLocation, String destination,
                                    LocalDateTime expectedTime,
                                    List<JoinDriverDto> joinDrivers, List<JoinDriverDto> waitingDrivers) {
        this.nickname = nickname;
        this.profilePicture = profilePicture;
        this.carPicture = carPicture;
        this.nowHeadCount = nowHeadCount;
        this.totalHeadCount = totalHeadCount;
        this.waitingJoinCount = waitingJoinCount;
        this.departDateTime = departDateTime;
        this.departLocation = departLocation;
        this.destination = destination;
        this.expectedTime = expectedTime;
        this.joinDrivers = joinDrivers;
        this.waitingDrivers = waitingDrivers;
    }

    public static OwnerDrivingDetailsDto of(Driving driving, List<JoinDriverDto> joinDrivers, List<JoinDriverDto> waitingDrivers) {
        return OwnerDrivingDetailsDto.builder()
                .nickname(driving.getMember().getNickname())
                .profilePicture(driving.getMember().getImgUrl())
                .carPicture(driving.getCar().getCarModel().getImageUrl())
                .nowHeadCount(joinDrivers.size())
                .totalHeadCount(driving.getTotalHeadCount())
                .waitingJoinCount(waitingDrivers.size())
                .departDateTime(driving.getDepartDateTime())
                .departLocation(driving.getDepartLocation())
                .destination(driving.getDestination())
                .expectedTime(driving.getExpectedTime())
                .joinDrivers(joinDrivers)
                .waitingDrivers(waitingDrivers)
                .build();
    }
}
