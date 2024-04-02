import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    /**
     * Setting up an AppointmentService object to be used for each test case
     */
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    /**
     * Test case for adding a new Appointment object
     */
    @Test
    @DisplayName("Add Appointment Test")
    void testAddAppointment() {
        // Adding a valid appointment
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // One day in the future
        appointmentService.addAppointment("1", futureDate, "Meeting");

        // Verify appointment is added
        assertNotNull(appointmentService.getAppointment("1"));
    }

    /**
     * Test case for adding a duplicate Appointment with an existing ID
     */
    @Test
    @DisplayName("Add Duplicate Appointment Test")
    void testAddDuplicateAppointment() {
        // Adding an appointment with existing ID
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // One day in the future
        appointmentService.addAppointment("1", futureDate, "Meeting");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appointmentService.addAppointment("1", futureDate, "Meeting"));

        // Verify appointment already exists
        assertEquals("Appointment ID already exists", exception.getMessage());
    }

    /**
     * Test case for deleting an Appointment by ID
     */
    @Test
    @DisplayName("Delete Appointment Test")
    void testDeleteAppointment() {
        // Adding an appointment
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // One day in the future
        appointmentService.addAppointment("1", futureDate, "Meeting");

        // Deleting the appointment
        appointmentService.deleteAppointment("1");

        // Verify appointment is deleted
        assertThrows(IllegalArgumentException.class, () -> appointmentService.getAppointment("1"));
    }

    /**
     * Test case for deleting an Appointment that does not exist
     */
    @Test
    @DisplayName("Delete Nonexistent Appointment Test")
    void testDeleteNonexistentAppointment() {
        // Attempting to delete a non-existent appointment
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appointmentService.deleteAppointment("2"));

        // Verify the appointment does not exist and cannot be deleted
        assertEquals("Appointment ID does not exist", exception.getMessage());
    }

    /**
     * Test case for retrieving an Appointment based on the ID
     */
    @Test
    @DisplayName("Get Appointment Test")
    void testGetAppointment() {
        // Adding an appointment
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // One day in the future
        appointmentService.addAppointment("1", futureDate, "Meeting");

        // Retrieve the appointment
        Appointment retrievedAppointment = appointmentService.getAppointment("1");

        // Verify the retrieved appointment
        assertNotNull(retrievedAppointment);
        assertEquals("1", retrievedAppointment.getAppointmentId());
    }

    /**
     * Test case for retrieving an Appointment based on an ID that does not exist
     */
    @Test
    @DisplayName("Get Nonexistent Appointment Test")
    void testGetNonexistentAppointment() {
        // Attempting to get a non-existent appointment
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appointmentService.getAppointment("2"));

        // Verify the appointment cannot be retrieved as its non-existent
        assertEquals("Appointment Id does not exist", exception.getMessage());
    }
}