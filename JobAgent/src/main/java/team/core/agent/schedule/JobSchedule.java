package team.core.agent.schedule;

import team.core.agent.task.ITask;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by wusq on 2015/3/26.
 */
public class JobSchedule {
    public static void main(String[] args) {
        String urlStr = "D:\\快盘\\GitHub\\CodeLabX\\JobAgent\\jarlib\\DemoTask.jar";
        String className = "demo.task.mytask";
        String[] params = null;
        StartJob(urlStr, className, params);
    }

    public static int StartJob(String jarPath, String className, String[] params) {
        try {
            URL url = new File(jarPath).toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
            Class<?> myClass = classLoader.loadClass(className);
            ITask sif = (ITask) myClass.newInstance();
            return sif.StartJob(params);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
