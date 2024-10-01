public class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing task: " + name);
        try {
            // Simulate some work with sleep
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Task " + name + " was interrupted: " + e.getMessage());
            // Optionally log the exception here instead of printing the full stack trace
        }
        System.out.println(Thread.currentThread().getName() + " has completed task: " + name);
    }
}
