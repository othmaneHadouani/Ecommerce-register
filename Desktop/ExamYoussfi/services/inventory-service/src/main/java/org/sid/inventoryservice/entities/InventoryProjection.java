package org.sid.inventoryservice.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullInventory",types = Product.class)
public interface InventoryProjection {

    public Long getId();
    public String getName();
    public double getPrice();

}
