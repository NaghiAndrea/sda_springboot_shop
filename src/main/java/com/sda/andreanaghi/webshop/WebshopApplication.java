package com.sda.andreanaghi.webshop;

import com.sda.andreanaghi.webshop.model.Account;
import com.sda.andreanaghi.webshop.model.Customer;
import com.sda.andreanaghi.webshop.repository.AccountRepository;
import com.sda.andreanaghi.webshop.service.CustomerService;
import com.sda.andreanaghi.webshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sda.andreanaghi.webshop.repository")
@EntityScan(basePackages = "com.sda.andreanaghi.webshop.model")
public class WebshopApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private MailService mailService;
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {

        SpringApplication.run(WebshopApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        //Here we have the context
        //Put here your code
        Account account1 = new Account();
       account1.setId(1L);

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customerService.addCustomer(account1,customer1);

        // customerService.getCustomerAccounts().forEach(account -> System.out.println(account));
        //Afiseaza tot din baza de date
        //customerService.getCustomerAccounts().forEach(System.out::println);

        mailService.sendMail("naghi.andrea@gmail.com", "client@icloud.com",
                "Mock mail subject", "Mock mail content");


        accountRepository.findAllByIsClosed(false).forEach(System.out::println);
        //accountRepository.findAllByBillingAddress()
    }
}
