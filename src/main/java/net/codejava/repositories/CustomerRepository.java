package net.codejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstname(String firstname);
    Customer findByLastname(String lastname);
}
