package ca.sheridancollege.ahmamarw.controllers;

import ca.sheridancollege.ahmamarw.database.DatabaseAccess;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/updateAppointment") // Define the base URL for this controller
public class UpdateAppointmentController {

    UpdateAppointmentController(DatabaseAccess databaseAccess) {
    }

    // Define a method to handle POST requests to "/updateAppointment"
    @PostMapping
    public String updateAppointment(@RequestParam Long id,
                                    @RequestParam String firstName,
                                    @RequestParam String email,
                                    @RequestParam String appointmentDate,
                                    @RequestParam String appointmentTime) {
        // Call the method in DatabaseAccess to update the appointment
        // Implement the logic to update the appointment in the database
        return "redirect:/"; // Redirect to the home page after updating the appointment
    }
}
