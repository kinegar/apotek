package com.egar.apotek.service;

import com.egar.apotek.dto.ProductSupplierTransactionDTO;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface ProductSupplierTransactionService {
    public ProductSupplierTransactionDTO save(ProductSupplierTransactionDTO productSupplierTransactionDTO);
    public ProductSupplierTransactionDTO findById(BigInteger id);
    public List<ProductSupplierTransactionDTO> findBySupplierId(BigInteger id);
    public List<ProductSupplierTransactionDTO> findByProductId(BigInteger id);
    public List<ProductSupplierTransactionDTO> findByTransactionDate(Date startDate, Date endDate);
}
