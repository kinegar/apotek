package com.egar.apotek.repository;

import com.egar.apotek.entity.ProductSupplierTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductSupplierTransactionRepository extends JpaRepository<ProductSupplierTransaction, BigInteger> {

    @Query(value = "Select pst.* FROM product_supplier_transaction WHERE pst.supplier_id = ?1",
    nativeQuery = true)
    public List<ProductSupplierTransaction> findBySupplierId(BigInteger id);

    @Query(value = "Select pst.* FROM product_supplier_transaction WHERE pst.product_id = ?1",
            nativeQuery = true)
    public List<ProductSupplierTransaction> findByProductId(BigInteger id);

    @Query(value = "Select pst.* FROM product_supplier_transaction WHERE WHERE pst.timestamp > ?1 AND pst.timestamp <= ?2",
            nativeQuery = true)
    public List<ProductSupplierTransaction> findByTransactionDate(Date startDate, Date endDate);

}
