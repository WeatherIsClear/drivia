package weather.clear.drivia.entity.paymentEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Payment {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalTime billingDatetime;
    private int amount;
}
