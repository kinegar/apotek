package com.egar.apotek.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierDTO {
    private BigInteger id;
    private String name;
}
