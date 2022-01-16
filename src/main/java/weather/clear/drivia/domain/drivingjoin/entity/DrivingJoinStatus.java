package weather.clear.drivia.domain.drivingjoin.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrivingJoinStatus {

    JOINED("조인 성공"), WAITING("대기중"), REJECT("거절됨"), EXPIRED("시간 만료");

    private final String joinStatus;

    @JsonCreator
    public static DrivingJoinStatus from(String status) {
        return DrivingJoinStatus.valueOf(status.toUpperCase());
    }
}
