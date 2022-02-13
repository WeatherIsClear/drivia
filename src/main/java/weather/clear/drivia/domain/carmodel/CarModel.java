package weather.clear.drivia.domain.carmodel;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_model_id")
    private Long id;

    private String carName;
    private String vendor;
    private String imageUrl;

    public CarModel(String carName, String vendor, String imageUrl) {
        this.carName = carName;
        this.vendor = vendor;
        this.imageUrl = imageUrl;
    }
}
