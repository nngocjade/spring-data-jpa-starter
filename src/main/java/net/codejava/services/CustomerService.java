package net.codejava.services;

import net.codejava.repositories.Customer;
import net.codejava.repositories.CustomerRepository;
import net.codejava.repositories.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> listAll() {

        return repo.findAll();
    }

    public void save(Customer customer) {

        repo.save(customer);
    }

    public Customer get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {

        repo.deleteById(id);
    }

    public Customer findByFirstName(String firstName){
        return repo.findByFirstname(firstName);
    }

    public Customer findByLastName(String lastName){
        return repo.findByLastname(lastName);
    }
}
