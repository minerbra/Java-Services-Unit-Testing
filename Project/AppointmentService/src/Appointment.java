import java.util.Date;

public class Appointment {

    private final String appointmentId;
    private Date date;
    private String description;

    public Appointment(String appointmentId, Date date, String description) {

        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment Id is null or greater than 10 characters");
        }

        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Date cannot be null or in the past");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is null or greater than 50 characters");
        }

        this.appointmentId = appointmentId;
        this.date = date;
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
