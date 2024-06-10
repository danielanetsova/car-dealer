package bg.softuni.carDealer.services;

import bg.softuni.carDealer.models.entities.Customer;
import bg.softuni.carDealer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean isDataSeeded() {
        return this.customerRepository.count() > 0;
    }

    public void saveCustomer(Customer customer) {
        this.customerRepository.saveAndFlush(customer);
    }

    public Customer getRandomCustomer() {
        int randomId = new Random().nextInt(1, 31);
        Optional<Customer> byId = this.customerRepository.findById(randomId);
        return byId.orElse(null);
    }

    public List<Customer> getAllCustomersSortedByBirthDate() {
        return this.customerRepository.findAllCustomersOrderedByDate();
    }
}
