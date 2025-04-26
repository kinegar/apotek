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
    private int numberOfTransaction;//jumlah transaksi
    private List<TransactionReportUnitSoldDTO> unitSold; //jumlah unit terjual
    private BigDecimal gross; //
    private List<TransactionReportUnitSoldDTO> unitRestock;
    private BigDecimal expense;
    private BigDecimal nett;
}
