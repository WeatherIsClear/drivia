package weather.clear.drivia.domain.drivingjoin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.member.entity.Member;

import javax.persistence.*;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class DrivingJoin {

    @Id
    @GeneratedValue
    @Column(name = "driving_join_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "driving_id")
    private Driving driving;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "driver_id")
    private Member member;

    @Enumerated(STRING)
    private DrivingJoinStatus status;

    @Builder
    private DrivingJoin(Driving driving, Member member, DrivingJoinStatus status) {
        this.driving = driving;
        this.member = member;
        this.status = status;
    }

    public static DrivingJoin of(Driving driving, Member member, DrivingJoinStatus status) {
        return DrivingJoin.builder()
                .driving(driving)
                .member(member)
                .status(status)
                .build();
    }
}
