package com.egar.apotek.dto;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionReportDTO {
    private Date startDate;
    private Date endDate;
    private int numberOfTransaction;
    private List<TransactionReportUnitSoldDTO> unitSold;
    private BigDecimal gross;
    private List<TransactionReportUnitSoldDTO> unitRestock;
    private BigDecimal expense;
    private BigDecimal nett;
}
