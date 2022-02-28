package weather.clear.drivia.entity.carEntitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class CarManufacturer {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private State state;
}
