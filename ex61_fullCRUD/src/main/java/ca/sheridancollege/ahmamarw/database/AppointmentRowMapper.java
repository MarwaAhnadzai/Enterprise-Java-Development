package ca.sheridancollege.ahmamarw.database;

import ca.sheridancollege.ahmamarw.beans.Appointment;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentRowMapper implements RowMapper<Appointment> {

    @Override
    public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setId(rs.getLong("id"));
        appointment.setFirstName(rs.getString("firstName"));
        appointment.setEmail(rs.getString("email"));
        appointment.setAppointmentDate(rs.getDate("appointmentDate").toLocalDate());
        appointment.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
        return appointment;
    }
}
