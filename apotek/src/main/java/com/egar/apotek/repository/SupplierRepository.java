package com.egar.apotek.repository;

import com.egar.apotek.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, BigInteger> {
}
