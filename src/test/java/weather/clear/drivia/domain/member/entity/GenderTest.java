package weather.clear.drivia.domain.member.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {


    @Test
    void genderTest() {
        g g1 = weather.clear.drivia.domain.member.entity.g.ofValue(1);
        g g3 = weather.clear.drivia.domain.member.entity.g.ofValue(3);
        g g2 = weather.clear.drivia.domain.member.entity.g.ofValue(2);
        g g4 = weather.clear.drivia.domain.member.entity.g.ofValue(4);
        g g7 = weather.clear.drivia.domain.member.entity.g.ofValue(7);
        g g8 = weather.clear.drivia.domain.member.entity.g.ofValue(8);

        System.out.println(g1.getGenderNumber());
        Gender.MALE.get
        Assertions.assertThat(g1).isEqualTo(g.MALE);
        Assertions.assertThat(g3).isEqualTo(g.MALE);
        Assertions.assertThat(g2).isEqualTo(g.FEMALE);
        Assertions.assertThat(g4).isEqualTo(g.FEMALE);
        Assertions.assertThat(g7).isEqualTo(g.FOREIGN_MALE);
        Assertions.assertThat(g8).isEqualTo(g.FOREIGN_FEMALE);
    }
}

enum g {
    MALE("13"),
    FEMALE("24"),
    FOREIGN_MALE("7"),
    FOREIGN_FEMALE("8");

    private String genderNumber;

    g(String genderNumber) {
        this.genderNumber = genderNumber;
    }

    public String getGenderNumber() {
        return genderNumber;
    }

    private static final Map<String, g> map = stream(values())
            .collect(toMap(g::getGenderNumber, Function.identity()));

    public static g ofValue(int genderNumber) {
        String key = map.keySet().stream().filter(k -> k.contains(String.valueOf(genderNumber)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 성별입니다."));

        return map.get(key);
    }
}