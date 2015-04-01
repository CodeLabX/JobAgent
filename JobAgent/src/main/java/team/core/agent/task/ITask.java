package team.core.agent.task;

/**
 * Created by wusq on 2015/3/27.
 */
public interface ITask {
    /**
     * @param args
     * @return -1标识失败 0标识成功
     */
    public int StartJob(String[] args);
}
