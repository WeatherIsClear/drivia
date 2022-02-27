package weather.clear.drivia.domain.generic;

import lombok.Getter;
import weather.clear.drivia.domain.enums.UserStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {

    private String name;
    private String email;
    private String phone;
    private UserStatus status;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = UserStatus.SignUp;
    }


    public boolean changeStatus(UserStatus status){
        this.status = status;
        return true;
    }
}
