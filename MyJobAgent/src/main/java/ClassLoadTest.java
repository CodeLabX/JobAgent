import java.io.File;
import java.net.ProtocolFamily;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLEncoder;

/**
 * Created by mqlv on 2015/3/25.
 */
public class ClassLoadTest {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        String urlStr = "d:\\Users\\mqlv\\Desktop\\java\\MyJobAgent\\out\\artifacts\\MyJobAgent_jar\\MyJobAgent\\MyTest.class";

        try {
            URL url = new File(urlStr).toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

            Class<?> myClass = classLoader.loadClass("MyTest");
            myClass.getMethod("printTest").invoke(null);

            Object o = myClass.newInstance();
            myClass.getMethod("withParam").invoke(o,null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
