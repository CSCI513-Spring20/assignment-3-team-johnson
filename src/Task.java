/* Task.java
 * Donald Johnson
 * CSCI 513
 * Assignment 3
 * 
 * Task.java extends AbstractTask (which implements Runnable), and concretizes the run() method which finds the factorial of a given number.
 */

public class Task extends AbstractTask{
	
	private int num;
	final private int end = 1;
    public Task(int n) {
        super("Number " + n);
        this.num = n;
    }


	@Override
	public void run() 
	{
		long fact = 0;
		int start = num;
		while (num > end) 
		{
			try 
		    {
			    Thread.sleep(100);
		    } 
		    catch (InterruptedException e) 
		    {
		    	e.printStackTrace();
		    }
			fact += num * (num - 1);
		    num--;	
			System.out.println(Thread.currentThread().getName() + ": calculated factorial " + fact);
		}
		System.out.println(Thread.currentThread().getName() + ": calculated factorial of " + start + " = " + fact);
	}
}
