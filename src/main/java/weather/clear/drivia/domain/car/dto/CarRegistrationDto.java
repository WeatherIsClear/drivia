package weather.clear.drivia.domain.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarRegistrationDto {

    private Long memberId;
    private Long carModelId;
    private String carNumber;
    private LocalDate registrationDate;
}
