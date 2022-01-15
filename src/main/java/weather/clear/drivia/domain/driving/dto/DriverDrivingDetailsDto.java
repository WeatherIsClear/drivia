package weather.clear.drivia.domain.driving.dto;

import lombok.Builder;
import weather.clear.drivia.domain.driving.Driving;

import java.time.LocalDateTime;

public class DriverDrivingDetailsDto {

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
    private int kmFromMe;

    @Builder
    private DriverDrivingDetailsDto(String nickname, String profilePicture, String carPicture,
                                    int nowHeadCount, int totalHeadCount, int waitingJoinCount,
                                    LocalDateTime departDateTime, String departLocation, String destination,
                                    LocalDateTime expectedTime, int kmFromMe) {
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
        this.kmFromMe = kmFromMe;
    }

    public static DriverDrivingDetailsDto of(Driving driving, int nowHeadCount, int waitingJoinCount, int kmFromMe) {
        return DriverDrivingDetailsDto.builder()
                .nickname(driving.getMember().getNickname())
                .profilePicture(driving.getMember().getImgUrl())
                .carPicture(driving.getCar().getCarModel().getImageUrl())
                .nowHeadCount(nowHeadCount)
                .totalHeadCount(driving.getTotalHeadCount())
                .waitingJoinCount(waitingJoinCount)
                .departDateTime(driving.getDepartDateTime())
                .departLocation(driving.getDepartLocation())
                .destination(driving.getDestination())
                .expectedTime(driving.getExpectedTime())
                .kmFromMe(kmFromMe)
                .build();
    }
}
