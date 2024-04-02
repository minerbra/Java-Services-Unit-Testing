import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TaskServiceTest {

    private TaskService testTaskService;

    @BeforeEach
    void setUp() {

        testTaskService = new TaskService();
        testTaskService.addTask("1", "Task", "Description");

    }

    @Test
    @DisplayName("Adding task validation")
    void testAddingContactToContactService() {
        assertThrows(IllegalArgumentException.class, () ->
                testTaskService.addTask("1", "Task", "Description"));
    }

    @Test
    @DisplayName("Deleting task validation")
    void testDeletingContactFromContactService() {
        testTaskService.deleteTask("1");
        assertThrows(IllegalArgumentException.class, () -> testTaskService.deleteTask("1"));
    }

    @Test
    @DisplayName("Updating task name validation")
    void testUpdateContactFirstNameFromContactService() {

        testTaskService.updateTask("1", "New task", "Description");
        assertEquals("New task", testTaskService.getTask("1").getName());

        assertThrows(IllegalArgumentException.class, () ->
                testTaskService.updateTask("1", "ThisTaskNameIsToLongToValidate", "Description"));

        assertEquals("New task", testTaskService.getTask("1").getName());

    }

    @Test
    @DisplayName("Updating task description validation")
    void testUpdateTaskDescriptionFromContactService() {

        testTaskService.updateTask("1", "Task", "New description");
        assertEquals("New description", testTaskService.getTask("1").getDescription());

        assertThrows(IllegalArgumentException.class, () ->
                testTaskService.updateTask("1", "Task", "thisDescriptionIsToLongToBeValidForATaskInTheSystem"));

        assertEquals("New description", testTaskService.getTask("1").getDescription());

    }


}
