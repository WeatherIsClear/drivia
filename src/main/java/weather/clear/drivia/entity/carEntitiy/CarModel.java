package weather.clear.drivia.entity.carEntitiy;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CarModel {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "car_seater_id")
    private CarSeater carSeater;

    @ManyToOne
    @JoinColumn(name = "car_transmisson_id")
    private CarTransmission carTransmission;

    @ManyToOne
    @JoinColumn(name = "car_manufacturer_id")
    private CarManufacturer carManufacturer;

}
