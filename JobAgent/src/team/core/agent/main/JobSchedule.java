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
		String class_path = "demo.mytask";// Jar�е�����Ҫ���ص��������
		String jar_path = "file://D:\\demo_task.jar";// jar���ڵ��ļ���URL
		
	
		
		
		try {

			URL[] urls={ new URL(jar_path) };
			
			@SuppressWarnings("resource")
			URLClassLoader myClassLoder= new URLClassLoader(urls);
			
			
			ITask sif = (ITask) myClassLoder.loadClass(class_path).newInstance();
			
			System.out.println(sif.StartJob(null));// ����Jar�е��෽��

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
