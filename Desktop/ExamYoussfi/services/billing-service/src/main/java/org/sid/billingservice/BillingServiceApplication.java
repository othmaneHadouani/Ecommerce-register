package org.sid.billingservice;
import org.sid.billingservice.dao.BillRepository;
import org.sid.billingservice.dao.ProductItemRepository;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.beans.Customer;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.proxies.CustomerServiceClient;
import org.sid.billingservice.proxies.InventoryServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient){
        return args -> {
            Bill bill=new Bill();
            bill.setBillingDate(new Date());
            Customer customer=customerServiceClient.findCustomerById(1L);
            bill.setCustomerID(customer.getId());
            billRepository.save(bill);
            inventoryServiceClient.findAll().getContent().forEach(p->{
                productItemRepository.save(new ProductItem(null,null,p.getId(),p.getPrice(),(int)(1+Math.random()*1000),bill));
            });
        };

}
}
