package ca.sheridancollege.ahmamarw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.ahmamarw.email.Email;

@Controller
public class EmailController {

    @Autowired
    private Email email;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        String senderEmail = "masha.ah003@gmail.com";
        String senderPassword = "sztxkywymndnwuvm";
        String recipientEmail = "java2024.sheridancollege@gmail.com";
        String subject = "Exercise 12.2";
        String body = "<html><body>" +
        		"<h2>Marwa Ahmadzai</h2>" +
                "<table border='1'>" +
                "<tr><th>Drink Name</th><th>Main Ingredient 1</th><th>Amount 1</th><th>Main Ingredient 2</th><th>Amount 2</th><th>Directions</th></tr>" +
                "<tr><td>Blackthorn</td><td>tonic water</td><td>1.5</td><td>pineapple juice</td><td>1</td><td>stir with ice, strain into cocktail glass with lemon twist</td></tr>" +
                "<tr><td>Blue Moon</td><td>soda</td><td>1.5</td><td>blueberry juice</td><td>0.75</td><td>stir with ice, strain into cocktail glass with lemon twist</td></tr>" +
                "<tr><td>Oh My Gosh</td><td>peach nectar</td><td>1</td><td>pineapple juice</td><td>1</td><td>stir with ice, strain into shot glass</td></tr>" +
                "<tr><td>Lime Fizz</td><td>Sprite</td><td>1.5</td><td>lime juice</td><td>0.75</td><td>stir with ice, strain into cocktail glass</td></tr>" +
                "<tr><td>Kiss on the Lips</td><td>cherry juice</td><td>2</td><td>apricot nectar</td><td>7</td><td>serve over ice with straw</td></tr>" +
                "<tr><td>Hot Gold</td><td>peach nectar</td><td>3</td><td>orange juice</td><td>6</td><td>pour hot orange juice in mug and add peach nectar</td></tr>" +
                "<tr><td>Lone Tree</td><td>soda</td><td>1.5</td><td>cherry juice</td><td>0.75</td><td>stir with ice, strain into cocktail glass</td></tr>" +
                "<tr><td>Greyhound</td><td>soda</td><td>1.5</td><td>grapefruit juice</td><td>5</td><td>serve over ice, stir well</td></tr>" +
                "<tr><td>Indian Summer</td><td>apple juice</td><td>2</td><td>hot tea</td><td>6</td><td>add juice to mug and top off with hot tea</td></tr>" +
                "<tr><td>Bull Frog</td><td>iced tea</td><td>1.5</td><td>lemonade</td><td>5</td><td>serve over ice with lime slice</td></tr>" +
                "<tr><td>Soda and It</td><td>soda</td><td>2</td><td>grape juice</td><td>1</td><td>shake in cocktail glass, no ice</td></tr>" +
                "</table>" +
                "<style>table {border-collapse: collapse; width: 100%;} th, td {padding: 8px; text-align: left;}</style>" +
                "</body></html>";


        email.sendEmail(senderEmail, senderPassword, recipientEmail, subject, body);

        return "index";
    }
}
