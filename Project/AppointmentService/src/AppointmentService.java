import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class AppointmentService {

    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>();
    }

    public void addAppointment(String appointmentId, Date date, String description) {

        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        Appointment appointment = new Appointment(appointmentId, date, description);
        appointments.put(appointmentId, appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        appointments.remove(appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        if(!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment Id does not exist");
        }
        return appointments.get(appointmentId);
    }
}
