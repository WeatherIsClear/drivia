package weather.clear.drivia;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.clear.drivia.entity.userEntity.User;
import weather.clear.drivia.repository.UserRepository;

import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private final UserRepository userRepository = mock(UserRepository.class);

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
