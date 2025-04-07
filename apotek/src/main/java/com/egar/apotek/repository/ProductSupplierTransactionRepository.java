package com.egar.apotek.repository;

import com.egar.apotek.entity.ProductSupplierTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductSupplierTransactionRepository extends JpaRepository<ProductSupplierTransaction, BigInteger> {
}
