/* Task.java
 * Donald Johnson
 * CSCI 513
 * Assignment 3
 * 
 * Task.java extends AbstractTask (which implements Runnable), and concretizes the run() method which finds the factorial of a given number.
 */

public class Task extends AbstractTask{
	
	private int num;
	public long calc;
	
    public Task(int n) {
        super("Number " + n);
        this.num = n;
    }
    
    public long calcFact(long n)
    {		
    	long fact = n * (n-1);
   		return fact;
    }


	@Override
	public void run() 
	{
		calc += calcFact(num);
		System.out.println(Thread.currentThread().getName() + ": calculated " + num + " * " + (num - 1) + " = " + calc);
		if (calc > 0) Main.totalSum *= calc;
	}
}
