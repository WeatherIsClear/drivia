package weather.clear.drivia.entity.drivingEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Driving {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    private Status status;
    private String from;
    private String to;
    private int maxDriver;
    private int joinedDriver;
    private LocalDateTime scheduleDatetime;
    private LocalTime estimatedTime;

}
