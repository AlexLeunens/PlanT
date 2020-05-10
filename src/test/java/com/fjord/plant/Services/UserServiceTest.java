package com.fjord.plant.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.fjord.plant.Model.User;
import com.fjord.plant.Repository.UserRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.mockito.MockitoAnnotations.initMocks;

@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    private final String USER_MAIL = "mail@mail.com";
    private final String USER_NAME = "name";

    @BeforeAll
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository, mockBCryptPasswordEncoder);

        user = new User();
        user.setEmail(USER_MAIL);
        user.setName(USER_NAME);
        user.setSurname("surname");
        user.setId(1);

        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
        Mockito.when(mockUserRepository.findByName(anyString())).thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {

        final User result = userServiceUnderTest.findUserByEmail(USER_MAIL);
        assertEquals(USER_MAIL, result.getEmail());
    }

    @Test
    public void testFindUserByName() {

        final User result = userServiceUnderTest.findUserByName("name");
        assertEquals(USER_NAME, result.getName());
    }

    @Test
    public void testSaveUser() {

        User newUser = new User();
        User result = userServiceUnderTest.saveUser(newUser);

        assertEquals(USER_MAIL, result.getEmail());
    }
}