package ca.sheridancollege.ahmamarw.database;

import ca.sheridancollege.ahmamarw.beans.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public void insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (firstName, email, appointmentDate, appointmentTime) " +
                     "VALUES (:firstName, :email, :appointmentDate, :appointmentTime)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", appointment.getFirstName());
        paramMap.put("email", appointment.getEmail());
        paramMap.put("appointmentDate", appointment.getAppointmentDate());
        paramMap.put("appointmentTime", appointment.getAppointmentTime());
        jdbc.update(sql, paramMap);
    }

    public List<Appointment> getAllAppointments() {
        String sql = "SELECT * FROM appointment";
        return jdbc.query(sql, new AppointmentRowMapper());
    }

    public void deleteAppointmentById(Long id) {
        String sql = "DELETE FROM appointment WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbc.update(sql, paramMap);
    }

    public <T> Appointment getAppointmentById(Long id) {
        String sql = "SELECT * FROM appointment WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbc.queryForObject(sql, paramMap, new AppointmentRowMapper());
    }
}
