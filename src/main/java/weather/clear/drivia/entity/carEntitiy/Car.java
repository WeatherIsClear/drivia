package weather.clear.drivia.entity.carEntitiy;

import lombok.Getter;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;

@Entity
@Getter
public class Car {

    @Id @GeneratedValue
    private Long id;
    private String carNumber;
    private Boolean isAuthenticate;

    @ManyToOne
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
