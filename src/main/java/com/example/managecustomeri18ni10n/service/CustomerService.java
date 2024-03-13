package com.example.managecustomeri18ni10n.service;

import com.example.managecustomeri18ni10n.model.Customer;
import com.example.managecustomeri18ni10n.repository.IRepositoryCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private IRepositoryCustomer iRepositoryCustomer;
    @Override
    public Iterable<Customer> findAll() {
        return iRepositoryCustomer.findAll();
    }



    @Override
    public void save(Customer customer) {
        iRepositoryCustomer.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iRepositoryCustomer.findById(id);
    }

    @Override
    public void remove(Long id) {
        iRepositoryCustomer.deleteById(id);
    }
}
