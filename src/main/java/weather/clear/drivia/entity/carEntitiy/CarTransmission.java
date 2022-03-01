package weather.clear.drivia.entity.carEntitiy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarTransmission {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;
}
