package weather.clear.drivia.domain.drivingjoin.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DrivingJoinStatus {

    JOIN, WAITING, REJECT, EXPIRED;

    @JsonCreator
    public static DrivingJoinStatus from(String status) {
        return DrivingJoinStatus.valueOf(status.toUpperCase());
    }
}