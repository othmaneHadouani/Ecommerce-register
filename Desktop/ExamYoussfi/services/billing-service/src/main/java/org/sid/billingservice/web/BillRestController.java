package org.sid.billingservice.web;

import org.sid.billingservice.dao.BillRepository;
import org.sid.billingservice.dao.ProductItemRepository;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.beans.Product;
import org.sid.billingservice.proxies.CustomerServiceClient;
import org.sid.billingservice.proxies.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController{


    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;
    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){


        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach ( pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill;

    }

    @GetMapping("/products/full/{id}")
    Product getProduct(@PathVariable(name="id") Long id){

        return inventoryServiceClient.findProductById(id );


    }

    @GetMapping("/products")
    PagedModel<Product> getProducts(){

        return inventoryServiceClient.findAll();


    }

}
