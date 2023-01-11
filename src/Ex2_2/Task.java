package Ex2_2;
import java.util.Objects;
import java.util.concurrent.Callable;

public class Task<T> implements Callable<T> , Comparable<Task<T>> {
    private TaskType taskType;
    private Callable <T> task;

    /**
     * Private constructor
     * @param task - Callable<T>
     */
    private Task(Callable<T> task) {
        this.task = task;
        setTaskType(TaskType.OTHER);
    }

    /**
     * Private constructor.
     * @param task - Callable<T>.
     * @param taskType - enum TaskType, represent priority.
     */
    private Task(Callable<T> task , TaskType taskType) {
        this.task = task;
        this.taskType = taskType;
    }

    /**
     * This method create a new Task.
     * @param callable - Callable.
     * @param taskType - enum TaskType, represent priority.
     * @return a new Task
     */
    public static Task createTask(Callable callable, TaskType taskType){
        return new Task(callable , taskType);
    }

    /**
     * This method create a new Task.
     * @param callable - Callable.
     * @return a new Task
     */
    public static Task createTask(Callable callable) {
        return new Task(callable);
    }

    /**
     * Return the current TaskType.
     * @return taskType.
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Return the Callable task.
     * @return Callable<T>.
     */
    public Callable<T> getTask() {
        return task;
    }

    /**
     * This method set the TaskType.
     * @param taskType - TaskType.
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * This method set the task.
     * @param task - Callable<T>.
     */
    public void setTask(Callable<T> task) {
        this.task = task;
    }

    /**
     * This method Computes a result, or throws an exception if unable to do so.
     * @return computed result.
     * @throws Exception – if unable to compute a result.
     */
    @Override
    public T call() throws Exception {

        try
        {
            return this.task.call();
        }
        catch (Exception e)
        {
                throw new Exception();
        }
    }

    /**
     *
     * @param otherTask the object to be compared.
     * @return 1 / -1 / 0 depends on if this taskType is larger smaller or even
     *          to the object to be compared.
     */
    @Override
    public int compareTo(Task<T> otherTask) {
        return  Integer.compare(this.taskType.getPriorityValue() , otherTask.taskType.getPriorityValue());
    }

    /**
     * This method check if 2 object are contain the same task and taskType.
     * @param o - Object
     * @return true if they are equals, else false.
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Task)) return false;
        Task<T> other = (Task)o;
        if(this.task.equals(other.task) && this.taskType.getPriorityValue() == other.taskType.getPriorityValue())
            return true;
        return false;
    }

    /**
     * Generates a hash code for the object.
     * @return a hash value of the sequence of input values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(task, taskType);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "{" + this.task.toString() +
                "Priority: " + taskType.getPriorityValue()
                + "}";
    }
}
