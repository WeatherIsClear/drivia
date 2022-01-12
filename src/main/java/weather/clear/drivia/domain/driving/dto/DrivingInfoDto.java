package weather.clear.drivia.domain.driving.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class DrivingInfoDto {

    private String nickname;

    private String profilePicture;

    private String carPicture;

    private int nowHeadCount;

    private int totalHeadCount;

    private int waitingJoinCount;

    private LocalDateTime departDateTime;

    private int kmFromMe;

    private String departure;

    private String destination;

    private String expectedTime;
}
