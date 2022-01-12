package weather.clear.drivia.domain.driving;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.car.Car;
import weather.clear.drivia.domain.driving.dto.CreatDrivingDto;
import weather.clear.drivia.domain.member.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Driving {

    @Id
    @GeneratedValue
    @Column(name = "driving_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "owner_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime departDateTime;

    private String departLocation;

    private LocalDateTime expectedTime;

    private String destination;

    private int nowHeadCount;

    private int totalHeadCount;

    @Builder
    private Driving(Member member, Car car, LocalDateTime departDateTime, String departLocation, String destination, int totalHeadCount) {
        this.member = member;
        this.car = car;
        this.departDateTime = departDateTime;
        this.departLocation = departLocation;
        this.destination = destination;
        this.totalHeadCount = totalHeadCount;
    }

    public static Driving of(Member member, Car car, CreatDrivingDto dto) {
        return Driving.builder()
                .member(member)
                .car(car)
                .departDateTime(dto.getDepartDateTime())
                .departLocation(dto.getDepartLocation())
                .destination(dto.getDestination())
                .totalHeadCount(dto.getTotalHeadCount())
                .build();
    }
}
