package com.revature.bookstore.services;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;
import org.junit.*;

public class UserServerTestSuite {

    UserService sut; // SUT =System under Test (the thing being tested)

    /*
    common Junit 4 Annotations

        -@BeforeClass
        -@AfterClass
        -@Before
        -@After
        -@Test
        -@Ignore

     */

    @BeforeClass // runs before all test cases; runs only once
    public static void setUpSuite() {
        System.out.println("before class, I run once!");
    }

    @AfterClass // runs after all test cases; runs only once
    public static void tearDownSuite() {
        System.out.println("After class, I run once!");
    }

    @Before // runs before each test case
    public void beforeEAchTest() {
        sut = new UserService(new UserRepository("")); // TODO fix this with mocking!
    }

    @After // runs after each test case
    public void afterEachTest() {
        sut = null;
    }

    @Test
    public void isUserValid_returnsTrue_givenValidUser() {

        // AAA- Arrange, Act, Assert

        //Arrange
        boolean expectedResult = true;
        AppUser validUser = new AppUser("valid", "valid", "valid", "valid", "valid", )
    }


}
