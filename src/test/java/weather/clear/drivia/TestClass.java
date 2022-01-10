package weather.clear.drivia;

import org.junit.jupiter.api.Test;
import weather.clear.drivia.domain.member.entity.Gender;

public class TestClass {

    @Test
    void test() {
        Gender male = Gender.valueOf("MALE");
        System.out.println(male);
    }
}
