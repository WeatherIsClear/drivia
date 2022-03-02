package weather.clear.drivia.domain.core;

import lombok.Getter;
import weather.clear.drivia.domain.enums.DrivingStatus;
import weather.clear.drivia.domain.generic.Address;
import weather.clear.drivia.domain.generic.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Driving {

    private final Address from;
    private final Address to;
    private LocalDateTime schedule;
    private final int estimated; // 예상소요시간 분으로 표현. ex) 1 = 1분, 120 = 120분
    private int maxDriver;
    private DrivingStatus status;
    private final User owner;
    
    private final List<Driver> drivers = new ArrayList<>();
    private final List<Join> joins = new ArrayList<>();

    public Driving(Address from, Address to, LocalDateTime schedule, int estimated, int maxDriver, User owner) {
        this.from = from;
        this.to = to;
        this.schedule = schedule;
        this.estimated = estimated;
        this.maxDriver = maxDriver;
        this.owner = owner;
        this.status = DrivingStatus.Registration;
    }

    public boolean changeStatus(DrivingStatus status){
        this.status = status;
        return true;
    }

}
