package weather.clear.drivia.domain.core;

import lombok.Getter;
import weather.clear.drivia.domain.enums.JoinStatus;
import weather.clear.drivia.domain.generic.User;

@Getter
public class Join {
    private final User user;
    private final Driving driving;
    private JoinStatus status;

    public Join(User user, Driving driving) {
        this.user = user;
        this.driving = driving;
        this.status = JoinStatus.Request;
    }

    public boolean changeStatus(JoinStatus status){
        this.status = status;
        return true;
    }
}
