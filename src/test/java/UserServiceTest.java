import com.gmail.kirilllapitsky.entity.User;
import com.gmail.kirilllapitsky.enumerable.Role;
import com.gmail.kirilllapitsky.repository.UserRepository;
import com.gmail.kirilllapitsky.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = SpringBootTest.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void changeUserRole_whenSaveAndRetreiveEntity_thenOK() {
        User user = new User("login", "password", Role.CLIENT, null);
        userRepository.save(user);
        userService.setRole(1L, Role.MANAGER);
        assertEquals(Role.MANAGER, userRepository.findById(1L).orElseThrow().getRole());
    }
}