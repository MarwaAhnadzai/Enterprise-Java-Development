package ca.sheridancollege.ahmamarw.controller;

import java.time.LocalDate;
import java.time.LocalTime; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.ahmamarw.beans.Appointment;


@Controller
public class HomeController {


    @PostMapping("/formPost")
    public String handleFormSubmission(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String appointmentDate,
            @RequestParam String appointmentTime,
            Model model) {
        
        LocalDate date = LocalDate.parse(appointmentDate);
        LocalTime time = LocalTime.parse(appointmentTime);

        Appointment appointment = new Appointment();
        appointment.setFirstName(firstName);
        appointment.setEmail(email);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);

        System.out.println("New Appointment:");
        System.out.println("First Name: " + appointment.getFirstName());
        System.out.println("Email: " + appointment.getEmail());
        System.out.println("Appointment Date: " + appointment.getAppointmentDate());
        System.out.println("Appointment Time: " + appointment.getAppointmentTime());

        model.addAttribute("appointment", appointment);

        return "working";
    }
}
