package weather.clear.drivia.domain.car;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.carmodel.CarModel;
import weather.clear.drivia.domain.member.entity.Member;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {

    @Id
    @GeneratedValue(strategy = IDENTITY)
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
