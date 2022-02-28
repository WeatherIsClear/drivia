package weather.clear.drivia.entity.carEntitiy;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CarSeater {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Seater seater;
}
