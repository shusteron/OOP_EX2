package Ex2_2;

import java.util.concurrent.*;

public class CustomExecutor extends ThreadPoolExecutor {
    private int[] max = {-1, 0, 0, 0}; /** The priority inside queue */
    private final int maxp = 10; /** the default priority  */

    /**
     * constructor
     */
    public CustomExecutor()
    {
        super(Runtime.getRuntime().availableProcessors()/2,
                Runtime.getRuntime().availableProcessors()-1,
                300,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>());
    }


    /**
     * Submits a value-returning Task for execution and returns a Future representing the pending results of the task.
     * @param task – the Task to submit.
     * @type <T> – the type of the task's result.
     * @return a Future representing pending completion of the task.
     * @throws IllegalArgumentException
     */
    public <T> Future<T> submit(Task<T> task){
        if (task != null) {
            max[task.getTaskType().getPriorityValue()]++;
            AdapterCall adapterCall = new AdapterCall<>(task, task.getTaskType().getPriorityValue());
            super.execute(adapterCall);
            return adapterCall;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Submits a value-returning task for execution and returns a Future representing the pending results of the task.
     * @param task - Callable<T> task
     * @type <T> – the type of the task's result.
     * @param taskType - enum TaskType
     * @return a Future representing pending completion of the task.
     */
    public <T> Future<T> submit(Callable<T> task , TaskType taskType) {
        if(task != null) return submit(Task.createTask(task , taskType));
        throw new IllegalArgumentException();
    }

    /**
     * Submits a value-returning task for execution and returns a Future representing the pending results of the task.
     * @param task - Callable<T> task
     * @type <T> – the type of the task's result.
     * @return a Future representing pending completion of the task.
     */
    @Override
    public <T> Future<T> submit(Callable<T> task)
    {
        if(task != null) return submit(Task.createTask(task));
        throw new IllegalArgumentException();
    }

    /**
     *This method activate before a task execute.
     * @param t the thread that will run task {@code r}
     * @param r the task that will be executed
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        if(r != null)  max[((AdapterCall) r).getP()]--;
    }

    /**
     * Return the max priority in queue
     * @return nax priority in queue
     */
    public int getCurrentMax()
    {
        boolean ok = false;
        int max_p = 3;
        for (int i = 3; i >= 1; i--) {
            if(max[i] > 0)
            {
                max_p = i;
                ok = true;
            }
        }
        if (ok) return max_p;
        return maxp;

    }

    /**
     * Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
     * Invocation has no additional effect if already shut down.
     */
    public void gracefullyTerminate() {
        super.shutdown();
        try
        {
            super.awaitTermination(50 , TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the core number of threads.
     * @param corePoolSize the new core size
     */
    @Override
    public void setCorePoolSize(int corePoolSize) {
        super.setCorePoolSize(corePoolSize);
    }

    /**
     * Returns the core number of threads
     * @return core number of threads
     */
    @Override
    public int getCorePoolSize() {
        return super.getCorePoolSize();
    }

    /**
     * Sets the maximum allowed number of threads.
     * @param maximumPoolSize the new maximum
     */
    @Override
    public void setMaximumPoolSize(int maximumPoolSize) {
        super.setMaximumPoolSize(maximumPoolSize);
    }

    /**
     * Returns the maximum allowed number of threads.
     * @return maximum allowed number of threads.
     */
    @Override
    public int getMaximumPoolSize() {
        return super.getMaximumPoolSize();
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns a string identifying this pool.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return  "Queue: " + super.getQueue().toString() +
                "\nmax priority in queue: " + getCurrentMax();
    }
}



