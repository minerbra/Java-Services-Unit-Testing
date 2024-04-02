import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService testContactService;

    @BeforeEach
    void setUp() {
        testContactService = new ContactService();
        testContactService.addContact("1", "John", "Doe", "3035555555", "Denver, CO");
    }

    @Test
    @DisplayName("Adding contact validation")
    void testAddingContactToContactService() {
        assertThrows(IllegalArgumentException.class, () ->
                testContactService.addContact("1", "John", "Doe", "3035555555", "Denver, CO"));
    }

    @Test
    @DisplayName("Deleting contact validation")
    void testDeletingContactFromContactService() {
        testContactService.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () ->
                testContactService.deleteContact("1"));
    }

    @Test
    @DisplayName("Updating contact fields validation")
    void testUpdateContactFieldsFromContactService() {
        testContactService.updateContact("1", "Dave", "Murray", "3036666666", "Lakewood, CO");

        assertEquals("Dave", testContactService.getContact("1").getFirstName());
        assertEquals("Murray", testContactService.getContact("1").getLastName());

        // Attempt to update first name and last name to values longer than 10 characters
        assertThrows(IllegalArgumentException.class, () ->
                testContactService.updateContact("1", "Christopher", "Fredricksburg", null, null));

        // Make sure the first name and last name remain unchanged after the invalid update
        assertEquals("Dave", testContactService.getContact("1").getFirstName());
        assertEquals("Murray", testContactService.getContact("1").getLastName());
    }

    @Test
    @DisplayName("Updating contact First Name validation")
    void testUpdateContactFirstNameFromContactService() {
        testContactService.updateContact("1", "Jack", "Doe", "3035555555", "Denver, CO");

        assertEquals("Jack", testContactService.getContact("1").getFirstName());

        assertThrows(IllegalArgumentException.class, () ->
                testContactService.updateContact("1", "Christopher", "Doe", "3035555555", "Denver, CO"));

        assertEquals("Jack", testContactService.getContact("1").getFirstName());

    }

    @Test
    @DisplayName("Updating contact Last Name validation")
    void testUpdateContactLastNameFromContactService() {
        testContactService.updateContact("1", "John", "Jackson", "3035555555", "Denver, CO");

        assertEquals("Jackson", testContactService.getContact("1").getLastName());

        assertThrows(IllegalArgumentException.class, () ->
                testContactService.updateContact("1", "John", "Christopherson", "3035555555", "Denver, CO"));

        assertEquals("Jackson", testContactService.getContact("1").getLastName());

    }

    @Test
    @DisplayName("Updating contact Phone validation")
    void testUpdateContactPhoneFromContactService() {
        testContactService.updateContact("1", "John", "Doe", "3036666666", "Denver, CO");

        assertEquals("3036666666", testContactService.getContact("1").getPhone());

        assertThrows(IllegalArgumentException.class, () ->
                testContactService.updateContact("1", "John", "Doe", "30377777777", "Denver, CO"));

        assertEquals("3036666666", testContactService.getContact("1").getPhone());

    }

    @Test
    @DisplayName("Updating contact Address validation")
    void testUpdateContactAddressFromContactService() {
        testContactService.updateContact("1", "John", "Doe", "3035555555", "Lakewood, CO");

        assertEquals("Lakewood, CO", testContactService.getContact("1").getAddress());

        assertThrows(IllegalArgumentException.class, () ->
                testContactService.updateContact("1", "John", "Doe", "3035555555", "ThisAddressIsToLongToBeAccepted"));

        assertEquals("Lakewood, CO", testContactService.getContact("1").getAddress());
    }
}
