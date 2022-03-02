package weather.clear.drivia;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import weather.clear.drivia.entity.userEntity.User;

import java.util.List;

import static org.mockito.Mockito.mock;

public class MockitoTest {

    /**
     *
     */
    @Test
    @DisplayName("")
    void mockitoTest() throws Exception
    {
        //given
        User userA = mock(User.class);
        System.out.println("userA = " + userA);
        //when

        //then
    }

}
