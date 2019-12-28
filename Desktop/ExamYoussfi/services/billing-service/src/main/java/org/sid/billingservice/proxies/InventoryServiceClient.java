package org.sid.billingservice.proxies;

import org.sid.billingservice.beans.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="inventory-service")
public interface InventoryServiceClient{

    @GetMapping("/products/{id}?projection=fullInventory")
    Product findProductById(@PathVariable("id") Long id);

    @GetMapping("/products?projection=fullInventory")
    PagedModel<Product> findAll();
}
