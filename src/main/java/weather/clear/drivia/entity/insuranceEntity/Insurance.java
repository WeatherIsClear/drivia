package weather.clear.drivia.entity.insuranceEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import weather.clear.drivia.entity.paymentEntity.Payment;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Insurance {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
