package team.core.agent.schedule;
import team.core.agent.DBUtility.SQLiteHelper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by wusq on 2015/3/26.
 */
public class JobSchedule {
    public static void main(String[] args) throws Exception {

        String sql = "insert into testtable(name, age) values(?,?)";
        SQLiteHelper.ExecuteNoTrans(SQLiteHelper.connString, sql,new Object[]{"mike",122});
        sql="select * from testtable";
        List<Map<String, Object>> lst= SQLiteHelper.Query(SQLiteHelper.connString, sql, null);
        for(Map<String, Object> m:lst)
        {
            System.out.println(m.get("name"));
        }



        if(true) return;

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
