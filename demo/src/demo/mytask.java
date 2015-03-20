/**
 * 
 */
package demo;
import java.util.Date;
/**
 * @author Administrator
 *
 */
public class mytask implements team.core.agent.task.ITask
{

	@Override
	public int StartJob(String[] arg0) {
		// TODO Auto-generated method stub
		System.out.print(new Date());
		return 0;
	}

}
