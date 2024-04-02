public class Task {

    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {

        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task Id is null or greater than 10 characters");
        }

        if (name == null || name.length() > 30) {
            throw new IllegalArgumentException("Task name cannot be null or greater than 30 characters");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description cannot be null or greater than 50 characters");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
