package weather.clear.drivia.entity.driverEntity;

import lombok.*;
import weather.clear.drivia.entity.drivingEntity.Driving;
import weather.clear.drivia.entity.insuranceEntity.Insurance;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    // == 연관관계 편의 메서드 == //
    public void joinDriving(Driving driving) {
        if(this.driving != null) {
            this.driving.getDrivers().remove(this);
        }
        this.driving = driving;
        driving.getDrivers().add(this);
    }
}
