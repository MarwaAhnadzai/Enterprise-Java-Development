package ca.sheridancollege.ahmamarw;

import org.springframework.stereotype.Component;

@Component // Indicates that this class is a Spring component
public class AuthenticationManager {

    public boolean authenticate(String username, String password) {
        // Add your authentication logic here
        return "admin".equals(username) && "password".equals(password);
    }
}
