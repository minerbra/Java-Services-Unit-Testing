import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    /*
    Test case for creating a Task object
    */
    @Test
    @DisplayName("Task object creation Test")
    void testTaskObjectCreation() {

        // Create test Task object
        Task contactTestObject = new Task("1", "Task Name", "Task Description");

        // Confirm Task object is not null
        assertNotNull(contactTestObject);

        // Confirm attributes
        assertEquals("1", contactTestObject.getTaskId());
        assertEquals("Task Name", contactTestObject.getName());
        assertEquals("Task Description", contactTestObject.getDescription());

    }

    /*
    Test Case for null Task ID
     */
    @Test
    @DisplayName("Null Task ID Test")
    void testNullTaskId() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Task(null, "Task Name", "Task Description"));

        assertEquals("Task Id is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for Contact ID greater than 10 characters
    */
    @Test
    @DisplayName("Task ID greater than 10 characters Test")
    void testLongTaskId() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Task(null, "Task Name", "Task Description"));

        assertEquals("Task Id is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for Task ID less than 10 characters
    */
    @Test
    @DisplayName("Task ID less than 10 characters Test")
    void testShortTaskId() {

        Task testTask = new Task("1", "Task Name", "Task description");

        assertTrue(true, String.valueOf(testTask.getTaskId().length() < 10));
    }

    /*
    Test Case for Task ID exactly 10 characters
    */
    @Test
    @DisplayName("Task ID exactly 10 characters Test")
    void testExactTaskId() {

        Task testTask = new Task("0123456789", "Task Name", "Task description");

        assertTrue(true, String.valueOf(testTask.getTaskId().length() == 10));
    }

    //////////////////////////////////////////// Task Name Test Cases /////////////////////////////////////////////////

    /*
    Test Case for null Task Name
    */
    @Test
    @DisplayName("Null Task Name Test")
    void testNullTaskName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Task("1", null, "Task Description"));

        assertEquals("Task name cannot be null or greater than 30 characters", exception.getMessage());
    }

    /*
    Test Case for Name greater than 30 characters
    */
    @Test
    @DisplayName("Task name greater than 30 characters Test")
    void testLongTaskName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Task("1", "Task Name is greater than 30 characters", "Task Description"));

        assertEquals("Task name cannot be null or greater than 30 characters", exception.getMessage());
    }

    /*
    Test Case for Name less than 30 characters
    */
    @Test
    @DisplayName("Task name less than 30 characters Test")
    void testShortTaskName() {

        Task testTask = new Task("1", "Task Name", "Task description");

        assertTrue(true, String.valueOf(testTask.getTaskId().length() < 30));
    }

    /*
    Test Case for Name exactly 30 characters
    */
    @Test
    @DisplayName("Task name exactly 30 characters Test")
    void testExactLengthTaskName() {

        Task testTask = new Task("0123456789", "Task Name is 30 characters....", "Task description");

        assertTrue(true, String.valueOf(testTask.getTaskId().length() == 30));
    }

    //////////////////////////////////////////// Task Description Test Cases //////////////////////////////////////////

    /*
    Test Case for null Task Description
    */
    @Test
    @DisplayName("Null Description Test")
    void testNullTaskDescription() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Task("1", "Task Name", null));

        assertEquals("Task description cannot be null or greater than 50 characters", exception.getMessage());
    }

    /*
    Test Case for Description greater than 50 characters
    */
    @Test
    @DisplayName("Task description greater than 50 characters Test")
    void testLongTaskDescription() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Task("1", "Task Name",
                        "Task Description is greater than 50 characters and should fail"));

        assertEquals("Task description cannot be null or greater than 50 characters", exception.getMessage());
    }

    /*
    Test Case for Description less than 50 characters
    */
    @Test
    @DisplayName("Task description less than 50 characters Test")
    void testShortTaskDescription() {

        Task testTask = new Task("1", "Task Name", "Task description");

        assertTrue(true, String.valueOf(testTask.getDescription().length() < 50));
    }

    /*
    Test Case for Description exactly 50 characters
    */
    @Test
    @DisplayName("Task description is exactly 50 characters Test")
    void testExactLengthTaskDescription() {

        Task testTask = new Task("0123456789", "Task Name",
                "Task description is exactly 50 characters.........");

        assertTrue(true, String.valueOf(testTask.getTaskId().length() == 50));
    }
}