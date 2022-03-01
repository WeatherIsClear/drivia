package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.paymentEntity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
