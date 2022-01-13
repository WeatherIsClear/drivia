package weather.clear.drivia.domain.drivingjoin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.member.entity.Member;

import javax.persistence.*;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.*;

@Entity
@Getter
@NoArgsConstructor
public class DrivingJoin {

    @Id
    @GeneratedValue
    @Column(name = "driving_join_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "driver_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "driving_id")
    private Driving driving;

    @Enumerated(STRING)
    private DrivingJoinStatus status = WAITING;

    @Builder
    private DrivingJoin(Member member, Driving driving) {
        this.member = member;
        this.driving = driving;
    }

    public static DrivingJoin of(Member member, Driving driving) {
        return DrivingJoin.builder()
                .member(member)
                .driving(driving)
                .build();
    }

    public void joinResult(DrivingJoinStatus status) {
        this.status = status;
    }
}
