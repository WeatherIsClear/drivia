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
public class RegistrationCarDto {

    private String carNumber;
    private LocalDate RegistrationDate;
    private String carName;
    private String vendor;
    private String imgUrl;
}
