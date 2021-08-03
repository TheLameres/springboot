package thelameres.springboot.services;

import thelameres.springboot.models.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);

    List<Customer> listAll();

    public Customer get(Long id);

    public void delete(Long id);

    public List<Customer> findByKeyword(String keyword);
}
