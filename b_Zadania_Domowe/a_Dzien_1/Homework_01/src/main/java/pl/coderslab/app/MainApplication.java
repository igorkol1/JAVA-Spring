package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.domain.Customer;
import pl.coderslab.logger.CustomerLogger;
import pl.coderslab.logger.SimpleCustomerLogger;
import pl.coderslab.repositories.CustomerRepository;
import pl.coderslab.repositories.MemoryCustomerRepository;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Customer customer = new Customer("Igor","Kolodziejczyk");

        CustomerRepository customerRepository = context.getBean(MemoryCustomerRepository.class);

        System.out.println("Add customer");
        customerRepository.addCustomer(customer);

        System.out.println("Print list of all customers");
        List<Customer> customerList = customerRepository.getCustomers();
        customerList.forEach(System.out::println);

        System.out.println("Remove customer");
        customerRepository.removeCustomer(customer);

    }

}
