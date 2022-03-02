package weather.clear.drivia.domain.core;

import lombok.Getter;
import weather.clear.drivia.domain.enums.DriverStatus;
import weather.clear.drivia.domain.generic.User;

@Getter
public class Driver {

    private final User user;
    private DriverStatus status;
    private Insurance insurance;

    public Driver(User user) {
        this.user = user;
        this.status = DriverStatus.Joined;
    }

    public boolean changeStatus(DriverStatus status){
        this.status = status;
        return true;
    }


    public void takeUpInsurance(Insurance insurance){
        if(this.insurance != null)
            this.insurance = insurance;
    }
}
