package com.egar.apotek.dto;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class TransactionDTO {
    private BigInteger id;
    private Date timestamp;
    private List<ProductTransactionDTO> productTransactions;
    private BigInteger pic;
    private BigDecimal totalPrice;

    public TransactionDTO() {
    }

    public TransactionDTO(BigInteger id, Date timestamp, List<ProductTransactionDTO> productTransactions, BigInteger pic, BigDecimal totalPrice) {
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

    public List<ProductTransactionDTO> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(List<ProductTransactionDTO> productTransactions) {
        this.productTransactions = productTransactions;
    }

    public BigInteger getPic() {
        return pic;
    }

    public void setPic(BigInteger pic) {
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
        return "TransactionDTO{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", productTransactions=" + productTransactions +
                ", pic=" + pic +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
