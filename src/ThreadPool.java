/* ThreadPool.java
 * Donald Johnson
 * CSCI 513
 * Assignment 3
 * 
 * ThreadPool.java is responsible for pooling together an array of tasks, starting these tasks, ensuring that each thread is executed
 * in a queue. This is assisted by the ThreadTask class, which itself implements Thread, that handles the queue of threads.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
	public final int size = 10;
	private final ThreadTask[] threadTasks;
	private boolean shutdown = false;
	private final Queue<Task> queue;
	private final ArrayList<Task> totalTasks;

	public ThreadPool() {
	        queue = new LinkedList<Task>();
	        totalTasks = new ArrayList<Task>();
	        threadTasks = new ThreadTask[this.size];
	        for (int i = 0; i < size; i++) {
	        	threadTasks[i] = new ThreadTask("Thread " + i);
	        	threadTasks[i].start();
	        }
	    }

	    public void execute(Task task) {
	        synchronized (queue) {
	            queue.add(task);
	            queue.notify();
	        }
	    }

	    public void waitForAllTasks() {
	        boolean hasPendingTask = true;
	        while (hasPendingTask) {
	            hasPendingTask = false;
	            for (Task task : totalTasks) {
	                if (task.getCompleted() == false) {
	                    hasPendingTask = true;
	                }
	            }
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                System.out.println("ERROR: Waiting for other threads...: " + e.getMessage());
	            }
	        }
	    }

	    public void shutdown() {
	        this.shutdown = true;
	    }

	    private class ThreadTask extends Thread {
	        public ThreadTask(String name) {
	            super(name);
	        }
	        @Override
	        public void run() {
	            Task task;
	            while (true) {
	                synchronized (queue) {
	                    if (shutdown && queue.isEmpty()) {
	                        break;
	                    }
	                    while (queue.isEmpty()) {
	                        try {
	                            queue.wait();
	                        } catch (InterruptedException e) {
	                            System.out.println("ERROR: Queue is waiting...: " + e.getMessage());
	                        }
	                    }
	                    task = (Task) queue.poll();
	                }
	                try {
	                    task.run();
	                    task.setCompleted();
	                    
	                } catch (RuntimeException e) {
	                    System.out.println("ERROR: Runtime exception...: " + e.getMessage());
	                }
	            }
	        }
	    }

	}
