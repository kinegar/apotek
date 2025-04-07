package com.egar.apotek.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionReportUnitSoldDTO {
    private String productName;
    private int stock;
}
