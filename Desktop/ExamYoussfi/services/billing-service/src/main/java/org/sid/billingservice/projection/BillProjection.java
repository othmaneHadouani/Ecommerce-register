package org.sid.billingservice.projection;
import org.sid.billingservice.beans.Customer;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.springframework.data.rest.core.config.Projection;
import java.util.Collection;
import java.util.Date;

@Projection(name = "fullBill",types = Bill.class)
public interface BillProjection {

    public Long getId();

    public Date getBillingDate();

    public Collection<ProductItem> getProductItems();

    public Customer getCustomer();


}
