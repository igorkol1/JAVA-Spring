package pl.coderslab.repositories;

import pl.coderslab.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    public void addCustomer(Customer customer);

    public void removeCustomer(Customer customer);

    public List<Customer> getCustomers();

}
