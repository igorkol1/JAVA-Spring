package pl.coderslab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.domain.Customer;
import pl.coderslab.logger.CustomerLogger;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {

    private List<Customer> customers;
    private CustomerLogger customerLogger;

    @Autowired
    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        customers = new ArrayList<>();
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        customerLogger.log();
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customerLogger.log();
    }

    @Override
    public List<Customer> getCustomers() {
        customerLogger.log();
        return customers;
    }
}
