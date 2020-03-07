import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void setup() {
        System.out.println("This is setup test");
    }

    @Test
    public void logIn() {
        System.out.println("This is log in test");
    }

    @Test
    public void logOut() {
        System.out.println("This is log out test");
    }
}
