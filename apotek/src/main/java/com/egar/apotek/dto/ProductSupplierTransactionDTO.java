package com.egar.apotek.dto;

import com.egar.apotek.entity.Product;
import com.egar.apotek.entity.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductSupplierTransactionDTO {
    private BigInteger id;
    private BigInteger product;
    private BigInteger supplier;
    private BigDecimal soldPrice;
    private int stock;
    private Timestamp timestamp;
}
