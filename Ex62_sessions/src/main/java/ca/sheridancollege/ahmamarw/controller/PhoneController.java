package ca.sheridancollege.ahmamarw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.ahmamarw.model.Phone;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
public class PhoneController {

    private int nextPhoneId = 1; // Initialize the ID counter

    // Display the index page with the form
    @GetMapping("/")
    public String getIndex(Model model, HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("phoneList", new ArrayList<Phone>());
        }
        model.addAttribute("phone", new Phone());
        model.addAttribute("phoneList", session.getAttribute("phoneList")); // Add phoneList to model
        return "index";
    }

    // Handle form submission and add phone to session
    @PostMapping("/insertPhone")
    public String insertPhone(@ModelAttribute("phone") Phone phone, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Phone> phoneList = (List<Phone>) session.getAttribute("phoneList");
        if (phoneList == null) {
            phoneList = new ArrayList<>();
        }
        
        // Set the ID for the phone
        phone.setId(nextPhoneId++);
        
        phoneList.add(phone);
        session.setAttribute("phoneList", phoneList);
        return "redirect:/";
    }
}


