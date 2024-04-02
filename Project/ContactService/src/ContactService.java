import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = contacts.get(contactId);

        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        } else throw new IllegalArgumentException("Cannot update first name. Must be less than 10 characters and not null.");

        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        } else throw new IllegalArgumentException("Cannot update last name. Must be less than 10 characters.");

        if (phoneNumber != null && phoneNumber.length() == 10) {
            contact.setPhone(phoneNumber);
        } else throw new IllegalArgumentException("Cannot update phone number. Must be exactly 10 digits");

        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        } else throw new IllegalArgumentException("Cannot update address. Must be less than 30 characters");
    }

    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        return contacts.get(contactId);
    }

    public void viewAllContacts() {
        System.out.println("All Contacts:");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}