package team.core.agent.schedule;

import team.core.agent.task.ITask;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Administrator on 2015/4/2.
 */
public class Task extends RecursiveAction {
    String JarPath;
    String ClassName;
    String[] Params;

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String[] getParams() {
        return Params;
    }

    public void setParams(String[] params) {
        Params = params;
    }

    public String getJarPath() {
        return JarPath;
    }

    public void setJarPath(String jarPath) {
        JarPath = jarPath;
    }

    public Task() {

    }

    public Task(String jarPath, String className, String[] params) {
        JarPath = jarPath;
        ClassName = className;
        Params = params;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName());
        StartJob();
        //test();
    }

    public int StartJob() {
        try {
            URL url = new File(JarPath).toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
            Class<?> myClass = classLoader.loadClass(ClassName);
            ITask sif = (ITask) myClass.newInstance();
            return sif.StartJob(Params);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void test() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
