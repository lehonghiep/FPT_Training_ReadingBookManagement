package fa.edu.controller;

import fa.edu.model.Users;

public interface CustomerController {
    Users login(String email, String password);
}
