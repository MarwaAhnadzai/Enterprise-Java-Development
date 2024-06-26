package ca.sheridancollege.ahmamarw.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drink {
    private int id;
    private String name;
    private String main1;
    private double amount1;
    private String main2;
    private double amount2;
    private String directions;
}
