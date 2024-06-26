package ca.sheridancollege.ahmamarw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ca.sheridancollege.ahmamarw.beans.Drink;
import ca.sheridancollege.ahmamarw.database.DrinkRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DrinkController {

    private final DrinkRepository drinkRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Assuming "home.html" is intended
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Assuming "login.html" is intended
    }

    @GetMapping("/permission-denied")
    public String permissionDenied() {
        return "error/permission-denied";
    }

    @GetMapping("/secure/add")
    public String showAddDrinkForm(Model model) {
        model.addAttribute("drink", new Drink());
        return "secure/addDrink";
    }

    @PostMapping("/secure/addDrink")
    public String processAddDrink(@ModelAttribute Drink drink) {
        drinkRepo.addDrink(drink);
        return "redirect:/secure/add"; // Redirect to the add drink form
    }

    @GetMapping("/view")
    public String viewDrinks(Model model) {
        model.addAttribute("drinks", drinkRepo.getDrinks());
        return "viewDrinks";
    }

    @GetMapping("/secure/editLink/{id}")
    public String showEditDrinkForm(Model model, @PathVariable int id) {
        Drink drink = drinkRepo.getDrinkById(id);
        model.addAttribute("drink", drink);
        return "secure/editDrink";
    }

    @PostMapping("/secure/editDrink")
    public String processEditDrink(@ModelAttribute Drink drink) {
        drinkRepo.updateDrink(drink);
        return "redirect:/view"; // Redirect to view drinks after editing
    }

    @GetMapping("/secure/deleteLink/{id}")
    public String deleteDrink(@PathVariable int id) {
        drinkRepo.deleteDrink(id);
        return "redirect:/view"; // Redirect to view drinks after deleting
    }
}

