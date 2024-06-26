package ca.marwa_ahmadzai;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, password, phone) " +
                     "VALUES (:name, :password, :phone)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", user.getName());
        paramMap.put("password", user.getPassword());
        paramMap.put("phone", user.getPhone());
        jdbcTemplate.update(sql, paramMap);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = :name, password = :password, phone = :phone WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", user.getId());
        paramMap.put("name", user.getName());
        paramMap.put("password", user.getPassword());
        paramMap.put("phone", user.getPhone());
        jdbcTemplate.update(sql, paramMap);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbcTemplate.update(sql, paramMap);
    }

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
