package ca.sheridancollege.ahmamarw.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class Appointment {

    private Long id;
    private String firstName;
    private String email;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;
    
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;

    // Constructor, getters, and setters omitted for brevity
}
