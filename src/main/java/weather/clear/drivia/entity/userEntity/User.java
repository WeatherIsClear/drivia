package weather.clear.drivia.entity.userEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import weather.clear.drivia.entity.insuranceEntity.Insurance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @Getter
    private Long id;

    private String name;
    private String eMail;
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    List<Insurance> insurances = new ArrayList<>();
}
