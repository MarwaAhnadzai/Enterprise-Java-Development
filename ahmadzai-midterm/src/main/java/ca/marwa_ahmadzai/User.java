package ca.marwa_ahmadzai;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String phone;
}
