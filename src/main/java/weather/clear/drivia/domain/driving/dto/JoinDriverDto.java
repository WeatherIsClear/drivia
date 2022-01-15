package weather.clear.drivia.domain.driving.dto;

import lombok.Getter;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

@Getter
public class JoinDriverDto {

    private String nickName;
    private String profilePicture;

    public JoinDriverDto(DrivingJoin drivingJoin) {
        nickName = drivingJoin.getMember().getNickname();
        profilePicture = drivingJoin.getMember().getImgUrl();
    }
}
