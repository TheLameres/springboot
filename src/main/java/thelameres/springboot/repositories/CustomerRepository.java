package thelameres.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import thelameres.springboot.models.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%' OR c.email LIKE '%' || :keyword || '%' OR c.address LIKE '%' || :keyword || '%'")
    public List<Customer> findCustomersByNameOrAddressOrEmail(@Param("keyword") String keyword);
}
