package com.egar.apotek.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;
    @Column(name = "timestamp", insertable = true, updatable = false)
    private Date timestamp;
    @OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private List<ProductTransaction> productTransactions;
    @ManyToOne
    @JoinColumn(name = "pic_id")
    private Employee pic;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public Transaction() {
    }

    public Transaction(BigInteger id, Date timestamp, List<ProductTransaction> productTransactions, Employee pic, BigDecimal totalPrice) {
        this.id = id;
        this.timestamp = timestamp;
        this.productTransactions = productTransactions;
        this.pic = pic;
        this.totalPrice = totalPrice;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(List<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }

    public Employee getPic() {
        return pic;
    }

    public void setPic(Employee pic) {
        this.pic = pic;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", productTransactions=" + productTransactions +
                ", pic=" + pic +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
