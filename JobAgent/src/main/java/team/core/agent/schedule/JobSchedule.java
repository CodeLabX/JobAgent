package team.core.agent.schedule;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by wusq on 2015/3/26.
 */
public class JobSchedule {
    public static void main(String[] args) {

/*        System.out.println(System.getProperty("user.dir"));

        String[] paths = System.getProperty("user.dir").split("\\\\");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < paths.length - 1; i++) {
            sb.append(paths[i] + "\\");
        }
        String urlStr = sb.toString() +"jarlib\\"+ "DemoTask.jar";
        System.out.println("jar包："+urlStr);

       */

/*        Properties configFile = new Properties();
        try {
            configFile.load(JobSchedule.class.getClassLoader().getResourceAsStream("config.properties"));
            String name = configFile.getProperty("jar_path");
            System.out.println(name);
        } catch (Exception e) {

            e.printStackTrace();
        }*/


        String urlStr = ConfigHelper.ReadConfig("jar_path")+ "\\DemoTask.jar";
        String className = "demo.task.mytask";
        String[] params = null;

        Task t = new Task(urlStr, className, params);
        Task t1 = new Task(urlStr, className, params);

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(t);
        pool.submit(t1);
        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

}
