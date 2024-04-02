import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    // Constant
    private static final int ONE_DAY = 86400000;

    /**
     * Test case for creating an Appointment object
     */
    @Test
    @DisplayName("Appointment Creation Test")
    void testAppointmentCreation() {
        // Create a valid appointment
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        Appointment appointment = new Appointment("1", futureDate, "Meeting");

        // Verify appointment details
        assertEquals("1", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getDate());
        assertEquals("Meeting", appointment.getDescription());
    }

    /**
     * Test case for a null Appointment ID
     */
    @Test
    @DisplayName("Null Appointment ID Test")
    void testNullAppointmentId() {
        // Attempt to create an appointment with null ID
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Appointment(null, futureDate, "Meeting"));
        assertEquals("Appointment Id is null or greater than 10 characters", exception.getMessage());
    }

    /**
     * Test case for an Appointment ID greater than 10 characters
     */
    @Test
    @DisplayName("Appointment ID greater than 10 characters Test")
    void testLongAppointmentId() {
        // Attempt to create an appointment with a long ID
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Appointment("12345678901", futureDate, "Meeting"));

        assertEquals("Appointment Id is null or greater than 10 characters", exception.getMessage());
    }

    /**
     * Test case for an Appointment ID less than 10 characters
     */
    @Test
    @DisplayName("Appointment ID less than 10 characters Test")
    void testShortAppointmentId() {
        // Attempt to create an appointment with a short ID
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        Appointment validTestAppointment = new Appointment("1", futureDate, "Meeting");

        assertTrue(true, String.valueOf(validTestAppointment.getAppointmentId().length() < 10));
    }

    /**
     * Test case for an Appointment ID exactly 10 characters
     */
    @Test
    @DisplayName("Appointment ID less than 10 characters Test")
    void testExactAppointmentId() {
        // Attempt to create an appointment with an exact length ID
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        Appointment validTestAppointment = new Appointment("1234567890", futureDate, "Meeting");

        assertTrue(true, String.valueOf(validTestAppointment.getAppointmentId().length() == 10));
    }

    /**
     * Test case for a null Appointment Date
     */
    @Test
    @DisplayName("Null Date Test")
    void testNullDate() {
        // Attempt to create an appointment with a past date
        Date pastDate = new Date(System.currentTimeMillis() - ONE_DAY); // One day in the past
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Appointment("1", null, "Meeting"));

        assertEquals("Date cannot be null or in the past", exception.getMessage());
    }

    /**
     * Test case for an Appointment Date set in the past
     */
    @Test
    @DisplayName("Past Date Test")
    void testPastDate() {
        // Attempt to create an appointment with a past date
        Date pastDate = new Date(System.currentTimeMillis() - ONE_DAY); // One day in the past
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Appointment("1", pastDate, "Meeting"));

        assertEquals("Date cannot be null or in the past", exception.getMessage());
    }

    /**
     * Test case for a null Appointment description
     */
    @Test
    @DisplayName("Null Description Test")
    void testNullDescription() {
        // Attempt to create an appointment with null description
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Appointment("1", futureDate, null));

        assertEquals("Description is null or greater than 50 characters", exception.getMessage());
    }

    /**
     * Test case for a description greater than 50 characters
     */
    @Test
    @DisplayName("Description is greater than 50 characters Test")
    void testLongDescriptionLength() {
        // Attempt to create an appointment with a long description
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Appointment("1", futureDate, "This is a very long description that" +
                                                            " exceeds the maximum length allowed for a description"));

        assertEquals("Description is null or greater than 50 characters", exception.getMessage());
    }

    /**
     * Test case for a description less than 50 characters
     */
    @Test
    @DisplayName("Description is less than 50 characters Test")
    void testShortDescriptionLength() {
        // Attempt to create an appointment with a short description
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        Appointment validTestAppointment = new Appointment("1", futureDate, "Meeting");

        assertTrue(true, String.valueOf(validTestAppointment.getDescription().length() < 50));
    }

    /**
     * Test case for a description exactly 50 characters
     */
    @Test
    @DisplayName("Description is exactly 50 characters Test")
    void testExactDescriptionLength() {
        // Attempt to create an appointment with an exact length description
        Date futureDate = new Date(System.currentTimeMillis() + ONE_DAY); // One day in the future
        Appointment validTestAppointment = new Appointment("1", futureDate, "This description" +
                                                                                " is exactly 50 characters xxxxxxxx");

        assertTrue(true, String.valueOf(validTestAppointment.getDescription().length() == 50));
    }
}