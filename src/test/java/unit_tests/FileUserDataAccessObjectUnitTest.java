package unit_tests;

import data_access.FileUserDataAccessObject;
import entity.CommonUser;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileUserDataAccessObjectUnitTest {

    private UserFactory userFactory;

    @BeforeEach
    void init() {
        userFactory = new CommonUserFactory();
    }

    @Test
    void testConstructorLargeCSV() {
        String resourcePath = "src/test/resources/large_users.csv";
        try {
            FileUserDataAccessObject dao = new FileUserDataAccessObject(resourcePath, userFactory);
        } catch (IOException er) {
            fail("Could not construct with large CSV");
        }
    }

    @Test
    void testConstructorSmallCSV() {
        String resourcePath = "src/test/resources/small_users.csv";
        try {
            FileUserDataAccessObject dao = new FileUserDataAccessObject(resourcePath, userFactory);
        } catch (IOException er) {
            fail("Could not construct with small CSV");
        }
    }

    @Test
    void testConstructorEmptyCSV() {
        String resourcePath = "src/test/resources/empty_users.csv";
        try {
            FileUserDataAccessObject dao = new FileUserDataAccessObject(resourcePath, userFactory);
        } catch (IOException er) {
            fail("Could not construct with empty CSV");
        }
    }

    @Test
    void testSaveGet() {
        String resourcePath = "src/test/resources/small_users.csv";
        FileUserDataAccessObject dao = null;
        try {
            dao = new FileUserDataAccessObject(resourcePath, userFactory);
        } catch (IOException er) {
            fail("Could not construct with small CSV");
        }

        assertEquals(dao.get("john_smith@gmail.com").getEmail(), "john_smith@gmail.com");
        assertEquals(dao.get("john_smith@gmail.com").getPassword(), "Abc123");
        assertEquals(dao.get("john_smith@gmail.com").getCreationTime(), LocalDateTime.parse("2023-01-01T00:00:00.0"));

        User user = userFactory.create("leo_peckham@notreal.com", ":)", LocalDateTime.parse("2004-12-31T23:59:59.99"));

        // MASSIVE TODO: we need a way to remove a user from the system, until then its not safe to
        // add a user, and thus jeopardize our test resources
        // this test will always fail until then

        // dao.save(user);

        // assertEquals(dao.get("leo_peckham@notreal.com").getEmail(), "leo_peckham@notreal.com");
        // assertEquals(dao.get("leo_peckham@notreal.com").getPassword(), ":)");
        // assertEquals(dao.get("leo_peckham@notreal.com").getCreationTime(), LocalDateTime.parse("2004-12-31T23:59:59.99"));

        assertNull(dao.get("notanemail@doesntexist.nope"));
    }

    @Test
    void testExistsByEmail() {
        String resourcePath = "src/test/resources/small_users.csv";
        FileUserDataAccessObject dao = null;
        try {
            dao = new FileUserDataAccessObject(resourcePath, userFactory);
        } catch (IOException er) {
            fail("Could not construct with small CSV");
        }

        assertTrue(dao.existsByEmail("mary1995@sympatico.ca"));
        assertFalse(dao.existsByEmail("notanemail@doesntexist.nope"));
    }

}
