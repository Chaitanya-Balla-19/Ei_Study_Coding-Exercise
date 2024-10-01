import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the thread pool:");
        int poolSize = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        ThreadPool pool = ThreadPool.getInstance(poolSize);

        String action;
        do {
            System.out.println("Enter 'submit' to add a task, 'shutdown' to close the pool, or 'exit' to quit:");
            action = scanner.nextLine();

            if (action.equalsIgnoreCase("submit")) {
                System.out.println("Enter task name:");
                String taskName = scanner.nextLine();
                Task task = new Task(taskName);
                pool.submitTask(task);
                System.out.println("Task " + taskName + " submitted to the pool.");
            } else if (action.equalsIgnoreCase("shutdown")) {
                pool.shutdown();
                break;
            }
        } while (!action.equalsIgnoreCase("exit"));

        scanner.close();
        System.out.println("Exiting the client.");
    }
}
