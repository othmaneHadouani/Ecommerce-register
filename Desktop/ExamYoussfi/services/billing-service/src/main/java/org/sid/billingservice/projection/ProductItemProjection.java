package org.sid.billingservice.projection;
import org.sid.billingservice.beans.Product;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "fullProductItem",types = ProductItem.class)
public interface ProductItemProjection {

    public Long getId();

    public Product getProduct();

    public double getPrice();

    public double getQuantity();

    public Bill getBBill();
}
