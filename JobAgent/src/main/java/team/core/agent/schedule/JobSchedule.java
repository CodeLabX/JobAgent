package team.core.agent.schedule;

import team.core.agent.task.ITask;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by wusq on 2015/3/26.
 */
public class JobSchedule {
    public static void main(String[] args) {
        String urlStr = "F:\\金山快盘\\项目\\JavaProject\\CodeLabX\\JobAgent\\jarlib\\DemoTask.jar";
        String className = "demo.task.mytask";
        String[] params = null;
        //StartJob(urlStr, className, params);
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
