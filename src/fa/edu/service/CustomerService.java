package fa.edu.service;

import fa.edu.model.Users;

public interface CustomerService {
    Users login(String user, String password);
}
