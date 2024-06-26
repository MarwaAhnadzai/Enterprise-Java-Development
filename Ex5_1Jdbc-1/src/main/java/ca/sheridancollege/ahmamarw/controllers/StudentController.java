package ca.sheridancollege.ahmamarw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ca.sheridancollege.ahmamarw.beans.*;
import ca.sheridancollege.ahmamarw.database.*;

@Controller
public class StudentController {

    @Autowired
    private DatabaseAccess da;

    @GetMapping("/")
    public String GetMapping(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        da.insertStudentHardCoded();
        return "index";
    }
}
