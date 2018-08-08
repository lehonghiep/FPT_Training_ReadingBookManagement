package fa.edu.service;

import fa.edu.model.Users;
import fa.edu.repository.CustomerRepository;
import fa.edu.repository.CustomerRepositoryImp;

public class CustomerServiceImp implements CustomerService {
    private CustomerRepository customerRepository=new CustomerRepositoryImp();
    @Override
    public Users login(String user, String password) {
        return customerRepository.login(user, password);
    }
}
