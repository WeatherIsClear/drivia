package weather.clear.drivia.domain.carmodel;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_model_id")
    private Long id;

    private String carName;
    private String vendor;
    private String imageUrl;
}
