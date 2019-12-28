package org.sid.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.beans.Customer;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Bill{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billingDate;

    @Transient
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;

    @Transient
    private Customer customer;

    private long customerID;


}

