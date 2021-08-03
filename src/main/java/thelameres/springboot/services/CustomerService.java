package thelameres.springboot.services;

import thelameres.springboot.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> listAll();

    Customer get(Long id);

    void delete(Long id);

    List<Customer> findByKeyword(String keyword);
}
