package weather.clear.drivia.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    /**
     * User Basic Test
     */
    @Test
    @DisplayName("User Basic Test")
    void userBasicTest() throws Exception
    {
        //given

        //when

        //then
    }


}