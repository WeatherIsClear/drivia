package weather.clear.drivia.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberSignUpDto {

    private String username;
    private String password;
    private String email;
    private String nickname;
    private LocalDate birth;
    private String gender;
    private String phone;

}
