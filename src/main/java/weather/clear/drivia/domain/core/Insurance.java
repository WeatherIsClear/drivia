package weather.clear.drivia.domain.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import weather.clear.drivia.domain.generic.User;

@Getter
@AllArgsConstructor
public class Insurance {
    private final User user;
    private final String name;
    private final int amount;

}
