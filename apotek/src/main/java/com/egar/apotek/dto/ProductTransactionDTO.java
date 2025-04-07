package com.egar.apotek.dto;

import com.egar.apotek.entity.Product;
import com.egar.apotek.entity.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class ProductTransactionDTO {
    private BigInteger id;
//    private BigInteger transaction;
    private BigInteger product;
    private int stock;
    private BigDecimal soldPrice;

    public ProductTransactionDTO() {
    }

    public ProductTransactionDTO(BigInteger id, BigInteger product, int stock, BigDecimal soldPrice) {
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

    public BigInteger getProduct() {
        return product;
    }

    public void setProduct(BigInteger product) {
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
        return "ProductTransactionDTO{" +
                "id=" + id +
                ", product=" + product +
                ", stock=" + stock +
                ", soldPrice=" + soldPrice +
                '}';
    }
}
