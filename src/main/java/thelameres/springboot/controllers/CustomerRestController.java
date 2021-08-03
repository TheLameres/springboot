package thelameres.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thelameres.springboot.models.Customer;
import thelameres.springboot.services.CustomerService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> listAll() {
        return customerService.listAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable("id") Long id) {
        return customerService.get(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("{id}")
    public Customer edit(@PathVariable("id") Long id, @RequestBody Customer customer) {
        if (customer.getId().equals(id)) {
            return customerService.save(customer);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        customerService.delete(id);
    }
}
