import java.util.UUID;
public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Generate a unique Contact ID no longer than 10 characters (ID_*******)
        // UUID uuid = UUID.randomUUID();
        // String uniqueId = uuid.toString().replace("-", "").substring(0, 7);
       // this.contactId = "ID_" + uniqueId;

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact Id is null or greater than 10 characters");
        }

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is null or greater than 10 characters");
        }

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is null or greater than 10 characters");
        }

        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits and not null");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is null or greater than 30 characters");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


