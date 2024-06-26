package ca.marwa_ahmadzai;


import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
    User findById(Long id);
    void update(User user);
    void deleteById(Long id);
	User findByUsername(String username);
}
