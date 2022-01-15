package weather.clear.drivia.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weather.clear.drivia.domain.member.dto.MemberSignUpDto;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String nickname;
    private LocalDate birth;
    private Gender gender;
    private String phone;
    private String imgUrl;

    @Builder
    private Member(String username, String password, String email, String nickname, LocalDate birth, Gender gender, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
    }

    public static Member of(MemberSignUpDto dto) {
        return Member.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .birth(dto.getBirth())
                .gender(Gender.ofValue(dto.getGender()))
                .phone(dto.getPhone())
                .build();
    }
}
