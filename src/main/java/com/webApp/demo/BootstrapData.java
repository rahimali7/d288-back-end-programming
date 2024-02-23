package com.webApp.demo;

import com.webApp.demo.dao.CustomerRepository;
import com.webApp.demo.dao.DivisionRepository;
import com.webApp.demo.entities.Customer;
import com.webApp.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Division KY = divisionRepository.findById(16L).orElse(null);
        Division MN = divisionRepository.findById(22L).orElse(null);
        Division WA = divisionRepository.findById(46L).orElse(null);
        Division TX = divisionRepository.findById(42L).orElse(null);
        Division EN = divisionRepository.findById(101L).orElse(null);


        Customer ahmed = new Customer("Ahmed", "Ali",
                "111 Somewhere st", "12345", "111-111-1111", KY);
        Customer john = new Customer("John", "Thompson",
                "222 Somewhere st", "12345", "222-222-2222", MN);
        Customer alex = new Customer("Alex", "Ferguson",
                "333 Somewhere st", "12345", "333-333-3333", WA);
        Customer melissa = new Customer("Melissa", "Stewart",
                "444 Somewhere st", "12345", "444-444-4444", TX);
        Customer tara = new Customer("Tara", "Dane",
                "555 Somewhere st", "12345", "555-555-5555", EN);


        customerRepository.save(ahmed);
        customerRepository.save(john);
        customerRepository.save(alex);
        customerRepository.save(melissa);
        customerRepository.save(tara);




    }
}
