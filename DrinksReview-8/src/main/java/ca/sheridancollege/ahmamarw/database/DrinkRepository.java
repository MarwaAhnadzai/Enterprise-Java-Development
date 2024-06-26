package ca.sheridancollege.ahmamarw.database;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ahmamarw.beans.Drink;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DrinkRepository {
    protected NamedParameterJdbcTemplate jdbc;

    public void addDrink(Drink drink) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "INSERT INTO easy_drinks (name, main1, amount1, main2, amount2, directions) VALUES "
                + "(:name, :main1, :amount1, :main2, :amount2, :directions)";
        parameters.addValue("name", drink.getName());
        parameters.addValue("main1", drink.getMain1());
        parameters.addValue("amount1", drink.getAmount1());
        parameters.addValue("main2", drink.getMain2());
        parameters.addValue("amount2", drink.getAmount2());
        parameters.addValue("directions", drink.getDirections());
        jdbc.update(query, parameters);
    }

    public ArrayList<Drink> getDrinks() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM easy_drinks";
        ArrayList<Drink> drinks = (ArrayList<Drink>) jdbc.query(query, parameters,
                new BeanPropertyRowMapper<Drink>(Drink.class));
        return drinks;
    }

    public Drink getDrinkById(int id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM easy_drinks WHERE id = :id";
        parameters.addValue("id", id);
        ArrayList<Drink> drinks = (ArrayList<Drink>) jdbc.query(query, parameters,
                new BeanPropertyRowMapper<Drink>(Drink.class));
        if (drinks.size() > 0) {
            return drinks.get(0);
        }
        return null;
    }

    public void updateDrink(Drink drink) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "UPDATE easy_drinks SET name = :name, main1 = :main1, amount1 = :amount1, "
                + "main2 = :main2, amount2 = :amount2, directions = :directions WHERE id = :id";
        parameters.addValue("name", drink.getName());
        parameters.addValue("main1", drink.getMain1());
        parameters.addValue("amount1", drink.getAmount1());
        parameters.addValue("main2", drink.getMain2());
        parameters.addValue("amount2", drink.getAmount2());
        parameters.addValue("directions", drink.getDirections());
        parameters.addValue("id", drink.getId());
        jdbc.update(query, parameters);
    }

    public void deleteDrink(int id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "DELETE FROM easy_drinks WHERE id = :id";
        parameters.addValue("id", id);
        jdbc.update(query, parameters);
    }
}
