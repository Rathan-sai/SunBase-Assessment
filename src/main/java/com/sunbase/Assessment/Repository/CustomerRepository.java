package com.sunbase.Assessment.Repository;

import com.sunbase.Assessment.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    List<Customer> findByfirstName(String firstName);
//    List<Customer> findBylastName(String lastName);
    List<Customer> findByfirstName(String firstName);
    List<Customer>findByCity(String city);
    List<Customer> findByEmail(String email);
    List<Customer> findByPhone(String phone);
}
