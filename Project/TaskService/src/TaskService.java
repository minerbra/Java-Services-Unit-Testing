import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public void addTask(String taskId, String name, String description) {
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        Task task = new Task(taskId, name, description );
        tasks.put(taskId, task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String name, String description) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        Task task = tasks.get(taskId);

        if (name != null && name.length() <= 20) {
            task.setName(name);
        } else throw new IllegalArgumentException("Cannot update name. Must be less than 20 characters and not null.");

        if (description != null && description.length() <= 50) {
            task.setDescription(description);
        } else throw new IllegalArgumentException("Cannot update description. Must be less than 50 characters and not null.");
    }
    public Task getTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        return tasks.get(taskId);
    }

    public void viewAllTasks() {
        System.out.println("All Tasks:");
        for (Map.Entry<String, Task> entry : tasks.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

}

