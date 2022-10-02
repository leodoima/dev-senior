package br.com.devsenior.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private double discountPercent;

    private double valueOrder;

    @Column(nullable = false)
    private StatusOrder statusOrder;


    public SalesOrder() {
    }

    public UUID getId() {
        return id;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public SalesOrder setDiscountPercent(double discountPercent) throws Exception {

        if (this.statusOrder == StatusOrder.CLOSED) {
            throw new Exception("Pedido encontra-se fechado");
        }

        this.discountPercent = discountPercent;

        return this;
    }

    public double getValueOrder() {
        return valueOrder;
    }

    public void setValueOrder(double valueOrder) {
        this.valueOrder = valueOrder;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public boolean isOrderActive() {
        return this.statusOrder == StatusOrder.OPEN;
    }

    public enum StatusOrder {
        OPEN,
        CLOSED
    }
}
