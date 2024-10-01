import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<TaskObserver> observers = new ArrayList<>();

    private ScheduleManager() {
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(message);
        }
    }

    public void addTask(Task task) {
        for (Task existingTask : tasks) {
            if (isOverlapping(task, existingTask)) {
                notifyObservers("Error: Task conflicts with existing task " + existingTask.getDescription() + 
                                " from " + existingTask.getStartTime() + " to " + existingTask.getEndTime());
                return;
            }
        }
        tasks.add(task);
        notifyObservers("Task added successfully: " + task.getDescription());
    }

    private boolean isOverlapping(Task newTask, Task existingTask) {
        return (newTask.getStartTime().compareTo(existingTask.getEndTime()) < 0 &&
                newTask.getEndTime().compareTo(existingTask.getStartTime()) > 0);
    }

    public void removeTask(String description) {
        boolean taskFound = tasks.removeIf(task -> task.getDescription().equals(description));
        if (taskFound) {
            notifyObservers("Task removed successfully: " + description);
        } else {
            notifyObservers("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.sort(Comparator.comparing(Task::getStartTime));
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void editTask(String description, String newDescription, String newStartTime, String newEndTime, String newPriority) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                // Temporarily store the old values
                String oldStartTime = task.getStartTime();
                String oldEndTime = task.getEndTime();

                // Update task fields
                task.setDescription(newDescription);
                task.setStartTime(newStartTime);
                task.setEndTime(newEndTime);
                task.setPriority(newPriority);

                // Check if the updated task now overlaps with any other tasks
                for (Task otherTask : tasks) {
                    if (otherTask != task && isOverlapping(task, otherTask)) {
                        // Restore old times if there's an overlap
                        task.setStartTime(oldStartTime);
                        task.setEndTime(oldEndTime);
                        notifyObservers("Error: Task conflicts with existing task " + otherTask.getDescription() +
                                        " from " + otherTask.getStartTime() + " to " + otherTask.getEndTime());
                        return;
                    }
                }

                // If no overlap was found, confirm the edit
                notifyObservers("Task edited successfully: " + newDescription);
                return;
            }
        }
        notifyObservers("Error: Task not found.");
    }

    public void markTaskAsCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.markAsCompleted();
                notifyObservers("Task marked as completed: " + description);
                return;
            }
        }
        notifyObservers("Error: Task not found.");
    }

    public void viewTasksByPriority(String priority) {
        tasks.stream()
            .filter(task -> task.getPriority().equalsIgnoreCase(priority))
            .sorted(Comparator.comparing(Task::getStartTime))
            .forEach(System.out::println);
    }
}
