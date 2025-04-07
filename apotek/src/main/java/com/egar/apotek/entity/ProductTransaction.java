package com.egar.apotek.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Table(name = "product_transaction")
public class ProductTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;
//    @ManyToOne
//    @JoinColumn(name = "transaction_id")
//    private Transaction transaction;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "stock")
    private int stock;
    @Column(name = "sold_price")
    private BigDecimal soldPrice;

    public ProductTransaction() {
    }

    public ProductTransaction(BigInteger id, Product product, int stock, BigDecimal soldPrice) {
        this.id = id;
        this.product = product;
        this.stock = stock;
        this.soldPrice = soldPrice;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(BigDecimal soldPrice) {
        this.soldPrice = soldPrice;
    }

    @Override
    public String toString() {
        return "ProductTransaction{" +
                "id=" + id +
                ", product=" + product +
                ", stock=" + stock +
                ", soldPrice=" + soldPrice +
                '}';
    }
}
