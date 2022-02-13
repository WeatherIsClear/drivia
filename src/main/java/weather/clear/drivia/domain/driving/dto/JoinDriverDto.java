package weather.clear.drivia.domain.driving.dto;

import lombok.Getter;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

@Getter
public class JoinDriverDto {

    private Long drivingJoinId;
    private Long driverId;
    private String nickName;
    private String profilePicture;

    public JoinDriverDto(DrivingJoin drivingJoin) {
        drivingJoinId = drivingJoin.getId();
        driverId = drivingJoin.getMember().getId();
        nickName = drivingJoin.getMember().getNickname();
        profilePicture = drivingJoin.getMember().getImgUrl();
    }
}
