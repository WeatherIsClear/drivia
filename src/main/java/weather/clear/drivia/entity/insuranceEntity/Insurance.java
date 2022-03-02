package weather.clear.drivia.entity.insuranceEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import weather.clear.drivia.entity.paymentEntity.Payment;
import weather.clear.drivia.entity.userEntity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    // == 연관관계 편의 메서드 == //
    public void addInsurance(User user) {
        this.user = user;
        user.getInsurances().add(this);
    }
}
