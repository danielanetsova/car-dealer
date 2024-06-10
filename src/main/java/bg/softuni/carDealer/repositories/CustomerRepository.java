package bg.softuni.carDealer.repositories;

import bg.softuni.carDealer.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("""
            FROM Customer c
            ORDER BY c.birthDate, c.isYoungDriver
            """)
    List<Customer> findAllCustomersOrderedByDate();
}
