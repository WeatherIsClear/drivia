package weather.clear.drivia;

import org.junit.jupiter.api.Test;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus;
import weather.clear.drivia.domain.member.entity.Gender;

import static weather.clear.drivia.domain.drivingjoin.entity.DrivingJoinStatus.*;

public class TestClass {

    @Test
    void test() {
        Gender male = Gender.valueOf("MALE");
        System.out.println(male);
    }

    @Test
    void test2() {
        DrivingJoinStatus join = valueOf("JOIN");
        System.out.println(join);
    }

    @Test
    void test3() {
        System.out.println(JOIN == JOIN);
        System.out.println(JOIN.equals(JOIN));
        System.out.println(JOIN.equals(REJECT));
        System.out.println(JOIN == REJECT);
    }
}
