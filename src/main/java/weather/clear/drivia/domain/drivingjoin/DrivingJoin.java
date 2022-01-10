package weather.clear.drivia.domain.drivingjoin;

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



}
