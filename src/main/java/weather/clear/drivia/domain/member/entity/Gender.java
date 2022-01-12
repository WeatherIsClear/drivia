package weather.clear.drivia.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("13"),
    FEMALE("24"),
    FOREIGN_MALE("7"),
    FOREIGN_FEMALE("8");

    private String genderNumber;

    private static final Map<String, Gender> map = Arrays.stream(values())
            .collect(Collectors.toMap(Gender::getGenderNumber, Function.identity()));

    public static Gender ofValue(int genderNumber) {
        String key = map.keySet().stream().filter(k -> k.contains(String.valueOf(genderNumber)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 성별입니다. gender=" + genderNumber));

        return map.get(key);
    }
}
