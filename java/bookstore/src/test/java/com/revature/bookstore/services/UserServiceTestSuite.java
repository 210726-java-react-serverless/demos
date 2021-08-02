package com.revature.bookstore.services;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;
import org.junit.*;

public class UserServiceTestSuite {

    UserService sut; // SUT = System Under Test (the thing being tested)

    /*
        Common JUnit 4 Annotations

            - @BeforeClass
            - @AfterClass
            - @Before
            - @After
            - @Test
            - @Ignore

     */

    @BeforeClass // runs before all test cases; runs only once
    public static void setUpSuite() {
        System.out.println("Before class, I run once!");
    }

    @AfterClass // runs after all test cases; runs only once
    public static void tearDownSuite() {
        System.out.println("After class, I run once!");
    }

    @Before // runs before each test case
    public void beforeEachTest() {
        System.out.println("Before test");
        sut = new UserService(new UserRepository("")); // TODO fix this with mocking!
    }

    @After // runs after each test case
    public void afterEachTest() {
        System.out.println("After test");
        sut = null;
    }

    @Test
    public void isUserValid_returnsTrue_givenValidUser() {

        System.out.println("Inside of isUserValid_returnsTrue_givenValidUser");

        // AAA - Arrange, Act, Assert

        // Arrange
        boolean expectedResult = true;
        AppUser validUser = new AppUser("valid", "valid", "valid", "valid", "valid");

        // Act
        boolean actualResult = sut.isUserValid(validUser);

        // Assert
        Assert.assertEquals("Expected user to be considered valid!", expectedResult, actualResult);

    }

    @Test
    public void isUserValid_returnsFalse_givenUserWithNullOrEmptyFirstName() {

        // Arrange
        AppUser invalidUser1 = new AppUser(null, "valid", "valid", "valid", "valid");
        AppUser invalidUser2 = new AppUser("", "valid", "valid", "valid", "valid");
        AppUser invalidUser3 = new AppUser("        ", "valid", "valid", "valid", "valid");

        // Act
        boolean actualResult1 = sut.isUserValid(invalidUser1);
        boolean actualResult2 = sut.isUserValid(invalidUser2);
        boolean actualResult3 = sut.isUserValid(invalidUser3);

        // Assert
        Assert.assertFalse("User first name cannot be null!", actualResult1);
        Assert.assertFalse("User first name cannot be an empty string!", actualResult2);
        Assert.assertFalse("User first name cannot be only whitespace!", actualResult3);

    }


}
