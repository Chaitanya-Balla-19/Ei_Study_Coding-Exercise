import java.util.Scanner;

public class Main {

    private static ScheduleManager scheduleManager = ScheduleManager.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Astronaut Daily Schedule Organizer!");

        User user = new User("Astronaut");
        scheduleManager.addObserver(user);

        while (true) {
            showMenu();
            int choice = getUserInput();
            processChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add a new task");
        System.out.println("2. Remove an existing task");
        System.out.println("3. View all tasks");
        System.out.println("4. Edit an existing task");
        System.out.println("5. Mark task as completed");
        System.out.println("6. View tasks by priority");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return -1;
        }
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addNewTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                viewAllTasks();
                break;
            case 4:
                editTask();
                break;
            case 5:
                markTaskAsCompleted();
                break;
            case 6:
                viewTasksByPriority();
                break;
            case 7:
                System.out.println("Exiting the application.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addNewTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High, Medium, Low): ");
        String priority = scanner.nextLine();

        if (!Validator.isValidTime(startTime) || !Validator.isValidTime(endTime)) {
            System.out.println("Error: Invalid time format.");
            return;
        }
        if (!Validator.isValidPriority(priority)) {
            System.out.println("Error: Invalid priority. Must be High, Medium, or Low.");
            return;
        }

        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
        scheduleManager.addTask(newTask);
    }

    private static void removeTask() {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        scheduleManager.removeTask(description);
    }

    private static void viewAllTasks() {
        scheduleManager.viewTasks();
    }

    private static void editTask() {
        System.out.print("Enter the task description to edit: ");
        String description = scanner.nextLine();
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new start time (HH:MM): ");
        String newStartTime = scanner.nextLine();
        System.out.print("Enter new end time (HH:MM): ");
        String newEndTime = scanner.nextLine();
        System.out.print("Enter new priority (High, Medium, Low): ");
        String newPriority = scanner.nextLine();

        if (!Validator.isValidTime(newStartTime) || !Validator.isValidTime(newEndTime)) {
            System.out.println("Error: Invalid time format.");
            return;
        }
        if (!Validator.isValidPriority(newPriority)) {
            System.out.println("Error: Invalid priority. Must be High, Medium, or Low.");
            return;
        }

        scheduleManager.editTask(description, newDescription, newStartTime, newEndTime, newPriority);
    }

    private static void markTaskAsCompleted() {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine();
        scheduleManager.markTaskAsCompleted(description);
    }

    private static void viewTasksByPriority() {
        System.out.print("Enter priority level (High, Medium, Low): ");
        String priority = scanner.nextLine();
        scheduleManager.viewTasksByPriority(priority);
    }
}
