/* AbstractTask.java
 * Donald Johnson
 * CSCI 513
 * Assignment 3
 * 
 * AbstractTask is an abstract class that implements Runnable and declares two variables,
 * which store the name of a given task as well as its completion status. These variables
 * are accompanied by cooresponding getters and a setter for the completed variable.
 */

public abstract class AbstractTask implements Runnable 
{
    String name;
    boolean completed;

    public AbstractTask(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted() {
    	completed = true;
    }
}
