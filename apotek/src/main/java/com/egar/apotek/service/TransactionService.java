package com.egar.apotek.service;

import com.egar.apotek.dto.TransactionDTO;
import com.egar.apotek.dto.TransactionReportDTO;
import com.egar.apotek.entity.Transaction;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface TransactionService {
    public TransactionDTO save(TransactionDTO transactionDTO);
    public TransactionDTO findById(BigInteger id);
    public List<TransactionDTO> findAll();
    public List<TransactionDTO> findByPicId(BigInteger id);
    public List<TransactionDTO> findByTransactionDate(Date startDate, Date endDate);
    public TransactionReportDTO transactionReport(Date startDate, Date endDate);
}
