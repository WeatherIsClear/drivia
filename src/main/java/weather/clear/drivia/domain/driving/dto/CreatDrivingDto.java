package weather.clear.drivia.domain.driving.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreatDrivingDto {

    private Long memberId;

    private Long carId;

    private LocalDateTime departDateTime;

    private String departLocation;

    private String destination;

    private int totalHeadCount;
}
