package team.core.agent.main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JobSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			foo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s = "";
		// while(true)
		// {
		//
		// }
		
		
	}


	public static void foo() throws Exception {
		String class_path = "demo.mytask";// Jar中的所需要加载的类的类名
		String jar_path = "file://D:\\demo_task.jar";// jar所在的文件的URL
		
	
		
		
		try {

			URL[] urls={ new URL(jar_path) };
			
			@SuppressWarnings("resource")
			URLClassLoader myClassLoder= new URLClassLoader(urls);
			
			
			ITask sif = (ITask) myClassLoder.loadClass(class_path).newInstance();
			
			System.out.println(sif.StartJob(null));// 调用Jar中的类方法

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (InstantiationException e) {

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		}
	}

}
