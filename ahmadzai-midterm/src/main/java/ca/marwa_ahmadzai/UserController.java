 package ca.marwa_ahmadzai;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to the Midterm!");
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("message", "User added successfully!");
        return "redirect:/";
    }


    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/users/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userRepository.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Check if the provided credentials match any existing user in the database
        boolean isAuthenticated = authenticateUser(username, password);

        if (!isAuthenticated) {
            // Redirect to error page with an appropriate error message
            return "redirect:/error?message=Invalid+username+or+password";
        } else {
            // Authentication successful, redirect to welcome page with username parameter
            return "redirect:/welcome?username=" + username;
        }
    }

    // Method to authenticate the user by checking if the credentials match any existing user
    private boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }


    @GetMapping("/welcome")
    public String welcomePage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        List<User> users = userRepository.findAll(); // Retrieve list of users
        model.addAttribute("users", users); // Add list of users to the model
        return "welcome";
    }


    @GetMapping("/error")
    public String showErrorPage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "error";
    }

    // Example authentication method, replace with your actual authentication logic
    @SuppressWarnings("unused")
    private boolean authenticate(final String username, final String password) {
        // Your authentication logic here
        return true; // Placeholder for successful authentication
    }
    
}


   