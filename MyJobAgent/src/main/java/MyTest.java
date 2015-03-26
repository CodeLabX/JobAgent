/**
 * Created by mqlv on 2015/3/25.
 */
public class MyTest {

    private String name = "d";

    public MyTest() {

    }

    public MyTest(String name) {
        this.name = name;
    }

    public static void printTest() {
        System.out.println("Hi...");
    }

    public void withParam() {
        System.out.println("Hi..." + name);
    }
}
