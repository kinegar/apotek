package com.egar.apotek.service;

import com.egar.apotek.dto.SupplierDTO;

import java.math.BigInteger;
import java.util.List;

public interface SupplierService {
    public SupplierDTO save(SupplierDTO supplierDTO);
    public List<SupplierDTO> findAll();
    public SupplierDTO findById(BigInteger id);
}
