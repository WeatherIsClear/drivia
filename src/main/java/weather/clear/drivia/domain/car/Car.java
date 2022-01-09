package weather.clear.drivia.domain.car;

import lombok.Getter;
import weather.clear.drivia.domain.carmodel.CarModel;
import weather.clear.drivia.domain.member.Member;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String carNumber;
    private LocalDate registrationDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;

}
