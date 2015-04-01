package demo.task;
import team.core.agent.task.ITask;
import java.util.Date;

/**
 * Created by wusq on 2015/3/31.
 */
public class mytask implements ITask
{
    @Override
    public int StartJob(String[] strings) {
        System.out.print(new Date());
        return 0;
    }
}

