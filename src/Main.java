/* Main.java
 * Donald Johnson
 * CSCI 513
 * Assignment 3
 * 
 * This Main class contains the main method which takes input from the user (the number to factorialize),
 * and declares the ThreadPool, the ArrayList of Tasks, 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static long totalSum = 1;
	public static void main(String[] args)
	{
		System.out.print("Enter the number to factorialize (limit 25): ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number > 100000) number = 100000;
        ThreadPool threadPool = new ThreadPool();
        ArrayList<Task> tasks = new ArrayList<Task>();
        
        int i = number;
        while (i > 0) {
        	Task task = new Task(i);
            threadPool.execute(task);
            tasks.add(task);
            i -= 2;
        }
        threadPool.waitForAllTasks();
        threadPool.shutdown();
        scanner.close();
        System.out.println("total: " + totalSum);
	}
}
