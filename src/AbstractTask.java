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
