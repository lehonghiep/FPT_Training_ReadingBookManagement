package fa.edu.repository;

import fa.edu.model.Users;

public interface CustomerRepository {
    Users login(String username, String password);
}
