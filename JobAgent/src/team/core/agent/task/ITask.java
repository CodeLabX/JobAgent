/**
 * 
 */
package team.core.agent.task;

/**
 * @author Administrator
 *
 */
public interface ITask {
	
	/**
	 * @param args
	 * @return -1标识失败 0标识成功
	 */
	public int StartJob(String[] args);
}
