package br.com.devsenior.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class SalesItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private double amount;

    private double unitaryValue;

    @OneToOne
    @JoinColumn(nullable = false)
    private SalesOrder salesOrder;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;


    public SalesItem() {
    }


    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }
}