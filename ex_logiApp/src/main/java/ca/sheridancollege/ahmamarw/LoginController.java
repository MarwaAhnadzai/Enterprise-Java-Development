package ca.sheridancollege.ahmamarw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // Indicates that this class serves as a controller in Spring MVC
public class LoginController {

    private final AuthenticationManager authenticationManager;

    @Autowired // Injects the AuthenticationManager bean
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/login") // Maps HTTP GET requests for "/login" to this method
    public String showLoginForm() {
        return "login"; // Returns the name of the Thymeleaf template to be rendered
    }

    @PostMapping("/login") // Maps HTTP POST requests for "/login" to this method
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Add your authentication logic here
        if (authenticationManager.authenticate(username, password)) {
            model.addAttribute("username", username); // Adds the username attribute to the model
            return "welcome"; // Returns the name of the Thymeleaf template to be rendered upon successful login
        } else {
            model.addAttribute("error", "Invalid username or password"); // Adds an error message attribute to the model
            return "login"; // Returns the name of the Thymeleaf template to be rendered if login fails
        }
    }
}
