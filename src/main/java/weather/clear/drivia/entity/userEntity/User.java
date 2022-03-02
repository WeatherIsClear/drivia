package weather.clear.drivia.entity.userEntity;

import lombok.*;
import weather.clear.drivia.entity.insuranceEntity.Insurance;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name", "eMail", "phoneNumber"})
public class User {

    @Id @Getter
    private Long id;

    private String name;
    private String eMail;
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Insurance> insurances = new ArrayList<>();
}
