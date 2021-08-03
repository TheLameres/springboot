package thelameres.springboot.services.impl;

import org.springframework.stereotype.Service;
import thelameres.springboot.models.Customer;
import thelameres.springboot.repositories.CustomerRepository;
import thelameres.springboot.services.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByKeyword(String keyword) {
        return customerRepository.findCustomersByNameOrAddressOrEmail(keyword);
    }
}
