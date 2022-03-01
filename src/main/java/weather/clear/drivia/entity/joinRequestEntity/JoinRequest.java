package weather.clear.drivia.entity.joinRequestEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.entity.drivingEntity.Driving;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinRequest {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "driving_id")
    private Driving driving;

    private Status status;


}
