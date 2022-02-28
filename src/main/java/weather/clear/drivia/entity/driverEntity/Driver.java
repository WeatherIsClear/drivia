package weather.clear.drivia.entity.driverEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import weather.clear.drivia.entity.drivingEntity.Driving;
import weather.clear.drivia.entity.insuranceEntity.Insurance;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Driver {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driving_id")
    private Driving driving;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User user;

    private Status status;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
}
