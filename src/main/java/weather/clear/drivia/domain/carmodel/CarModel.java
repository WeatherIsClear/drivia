package weather.clear.drivia.domain.carmodel;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.car.dto.RegistrationCarDto;

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

    @Builder
    private CarModel(String carName, String vendor, String imageUrl) {
        this.carName = carName;
        this.vendor = vendor;
        this.imageUrl = imageUrl;
    }

    public static CarModel of(RegistrationCarDto request) {
        return CarModel.builder()
                .carName(request.getCarName())
                .vendor(request.getVendor())
                .imageUrl(request.getImgUrl())
                .build();
    }
}
