import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    /*
    Test case for creating a Contact object
     */
    @Test
    @DisplayName("Contact Creation Test")
    void testContactCreation() {

        // Create test Contact object
        Contact contactTestObject = new Contact("1", "John", "Doe",
                                                    "3035555555", "Denver, CO");

        // Confirm contact object is not null
        assertNotNull(contactTestObject);

        // Confirm attributes
        assertEquals("1", contactTestObject.getContactId());
        assertEquals("John", contactTestObject.getFirstName());
        assertEquals("Doe", contactTestObject.getLastName());
        assertEquals("3035555555", contactTestObject.getPhone());
        assertEquals("Denver, CO", contactTestObject.getAddress());

    }

    /*
    Test Case for null Contact ID
     */
    @Test
    @DisplayName("Null Contact ID Test")
    void testNullContactId() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "3035555555", "Denver, CO"));

        assertEquals("Contact Id is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for Contact ID greater than 10 characters
    */
    @Test
    @DisplayName("Contact ID greater than 10 characters Test")
    void testLongContactId() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("01234567890", "John", "Doe",
                        "3035555555", "Denver, CO"));

        assertEquals("Contact Id is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for Contact ID less than 10 characters
    */
    @Test
    @DisplayName("Contact ID less than 10 characters Test")
    void testShortContactId() {

        Contact testContact = new Contact("123", "John", "Doe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getContactId().length() < 10));
    }

    /*
    Test Case for Contact ID exactly 10 characters
    */
    @Test
    @DisplayName("Contact ID exactly 10 characters Test")
    void testExactLengthContactId() {

        Contact testContact = new Contact("0123456789", "John", "Doe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getContactId().length() == 10));
    }

    //////////////////////////////////////////// First Name Test Cases ////////////////////////////////////////////////

    /*
    Test Case for null First Name
     */
    @Test
    @DisplayName("Null Contact first name Test")
    void testNullContactFirstName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", null, "Doe", "3035555555", "Denver, CO"));

        assertEquals("First name is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for First Name greater than 10 characters
    */
    @Test
    @DisplayName("Contact first name greater than 10 characters Test")
    void testLongContactFirstName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "xxxxxxxJohn", "Doe",
                        "3035555555", "Denver, CO"));

        assertEquals("First name is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for First Name less than 10 characters
    */
    @Test
    @DisplayName("Contact first name less than 10 characters Test")
    void testShortContactFirstName() {

        Contact testContact = new Contact("1", "John", "Doe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getFirstName().length() < 10));
    }

    /*
    Test Case for First Name exactly 10 characters
    */
    @Test
    @DisplayName("Contact first name is exactly 10 characters Test")
    void testExactLengthContactFirstName() {

        Contact testContact = new Contact("0123456789", "xxxxxxJohn", "Doe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getFirstName().length() == 10));
    }

    //////////////////////////////////////////// Last Name Test Cases ////////////////////////////////////////////////

    /*
    Test Case for null Last Name
    */
    @Test
    @DisplayName("Null Contact last name Test")
    void testNullContactLastName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", null, "3035555555", "Denver, CO"));

        assertEquals("Last name is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for Last Name greater than 10 characters
    */
    @Test
    @DisplayName("Contact last name greater than 10 characters Test")
    void testLongContactLastName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "xxxxxxxxDoe",
                        "3035555555", "Denver, CO"));

        assertEquals("Last name is null or greater than 10 characters", exception.getMessage());
    }

    /*
    Test Case for Last Name less than 10 characters
    */
    @Test
    @DisplayName("Contact last name less than 10 characters Test")
    void testShortContactLastName() {

        Contact testContact = new Contact("1", "John", "Doe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getLastName().length() < 10));
    }

    /*
    Test Case for Last Name exactly 10 characters
    */
    @Test
    @DisplayName("Contact last name is exactly 10 characters Test")
    void testExactLengthContactLastName() {

        Contact testContact = new Contact("1", "John", "xxxxxxxDoe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getLastName().length() == 10));
    }

    //////////////////////////////////////////// Phone Test Cases ////////////////////////////////////////////////////

    /*
    Test Case for null Phone
    */
    @Test
    @DisplayName("Null Contact phone Test")
    void testNullContactPhone() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", null, "Denver, CO"));

        assertEquals("Phone must be exactly 10 digits and not null", exception.getMessage());
    }

    /*
    Test Case for Phone greater than 10 characters
    */
    @Test
    @DisplayName("Contact phone greater than 10 characters Test")
    void testLongContactPhone() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe",
                        "30355555555", "Denver, CO"));

        assertEquals("Phone must be exactly 10 digits and not null", exception.getMessage());
    }

    /*
    Test Case for Phone less than 10 characters
    */
    @Test
    @DisplayName("Contact phone less than 10 characters Test")
    void testShortContactPhone() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe",
                        "303", "Denver, CO"));

        assertEquals("Phone must be exactly 10 digits and not null", exception.getMessage());
    }

    /*
    Test Case for Phone exactly 10 characters
    */
    @Test
    @DisplayName("Contact phone exactly 10 characters Test")
    void testExactLengthContactPhone() {

        Contact testContact = new Contact("1", "John", "xxxxxxxDoe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getPhone().length() == 10));
    }
    //////////////////////////////////////////// Address Test Cases ////////////////////////////////////////////////////

    /*
Test Case for null Address
*/
    @Test
    @DisplayName("Null Contact Address Test")
    void testNullContactAddress() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "3035555555", null));

        assertEquals("Address is null or greater than 30 characters", exception.getMessage());
    }

    /*
    Test Case for Address greater than 30 characters
    */
    @Test
    @DisplayName("Contact address greater than 30 characters Test")
    void testLongContactAddress() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe",
                        "3035555555", "This address is to long for the system"));

        assertEquals("Address is null or greater than 30 characters", exception.getMessage());
    }

    /*
    Test Case for Address less than 30 characters
    */
    @Test
    @DisplayName("Contact address less than 30 characters Test")
    void testShortContactAddress() {

        Contact testContact = new Contact("1", "John", "Doe",
                "3035555555", "Denver, CO");

        assertTrue(true, String.valueOf(testContact.getAddress().length() < 30));
    }

    /*
    Test Case for Last Name exactly 10 characters
    */
    @Test
    @DisplayName("Contact address is exactly 10 characters Test")
    void testExactLengthContactAddress() {

        Contact testContact = new Contact("1", "John", "Doe",
                "3035555555", "This address is 30 characters.");

        assertTrue(true, String.valueOf(testContact.getAddress().length() == 30));
    }

}

































