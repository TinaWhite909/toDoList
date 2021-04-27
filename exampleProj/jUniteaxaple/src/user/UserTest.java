package user;
import org.junit.Assert;
import org.junit.Test;
import javax.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    public void getAllUsers() {
        User user = new User("Evgen", 35, User.Sex.MALE);
        User user1 = new User("Marina", 34, User.Sex.FEMALE);
        User user2 = new User("Alina", 7, User.Sex.FEMALE);

        List<User> expected = User.getAllUsers();

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void testGetAllUsers_NO_NULL() {
        List<User>expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }
    @org.junit.jupiter.api.Test
    void testGetAllUsers_MALE() {
        User user = new User("Евгений", 35, User.Sex.MALE);
        User user1 = new User("Марина", 34, User.Sex.FEMALE);
        User user2 = new User("Алина", 7, User.Sex.FEMALE);

        List<User> expected = User.getAllUsers(User.Sex.MALE);

        List<User> actual = new ArrayList<>();
        actual.add(user);

        Assert.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getHowManyUsers() {
    }

    @org.junit.jupiter.api.Test
    void testGetHowManyUsers() {
    }

    @org.junit.jupiter.api.Test
    void getAllAgeUsers() {
    }

    @org.junit.jupiter.api.Test
    void testGetAllAgeUsers() {
    }

    @org.junit.jupiter.api.Test
    void getAverageAgeOfAllUsers() {
    }

    @org.junit.jupiter.api.Test
    void testGetAverageAgeOfAllUsers() {
    }
}