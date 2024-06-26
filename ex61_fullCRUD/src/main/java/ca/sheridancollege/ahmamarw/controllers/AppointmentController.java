package ca.sheridancollege.ahmamarw.controllers;

import ca.sheridancollege.ahmamarw.beans.Appointment;
import ca.sheridancollege.ahmamarw.database.DatabaseAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/")
    public String getAllAppointments(Model model) {
        List<Appointment> appointments = databaseAccess.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "index";
    }

    @PostMapping("/insertAppointment")
    public String insertAppointment(@ModelAttribute Appointment appointment) {
        databaseAccess.insertAppointment(appointment);
        return "redirect:/";
    }

    @GetMapping("/editAppointment/{id}")
    public String editAppointment(@PathVariable Long id, Model model) {
        Appointment appointment = databaseAccess.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "edit";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        databaseAccess.deleteAppointmentById(id);
        return "redirect:/";
    }
}


