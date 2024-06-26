package ca.sheridancollege.ahmamarw.beans;

import org.springframework.stereotype.Component;

@Component
public class Message {

    private String sayThis = "Woah!  Injection is powerful stuff!";

    @Override
    public String toString() {
        return "Message [sayThis=" + sayThis + "]";
    }
}