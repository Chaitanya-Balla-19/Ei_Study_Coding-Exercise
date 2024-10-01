import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static ThreadPool instance;
    private final ExecutorService executor;

    // Private constructor to prevent instantiation
    private ThreadPool(int poolSize) {
        // Create a fixed thread pool
        executor = Executors.newFixedThreadPool(poolSize);
    }

    // Get the singleton instance
    public static synchronized ThreadPool getInstance(int poolSize) {
        if (instance == null) {
            instance = new ThreadPool(poolSize);
        }
        return instance;
    }

    // Submit a task to the pool
    public void submitTask(Runnable task) {
        executor.submit(task);
    }

    // Shut down the pool gracefully
    public void shutdown() {
        executor.shutdown();
        System.out.println("ThreadPool has been shut down.");
    }
}
