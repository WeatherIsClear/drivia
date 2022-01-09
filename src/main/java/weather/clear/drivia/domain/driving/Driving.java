package weather.clear.drivia.domain.driving;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.member.Member;

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

    private LocalDateTime departDateTime;

    private String departLocation;

    private LocalDateTime expectedTime;

    private String destinationLocation;
}
