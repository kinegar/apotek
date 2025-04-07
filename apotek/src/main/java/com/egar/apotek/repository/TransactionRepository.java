package com.egar.apotek.repository;

import com.egar.apotek.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, BigInteger> {
    @Query(value = "SELECT * FROM transaction t" +
            "INNER JOIN employee e ON t.pic_id = e.id" +
            "INNER JOIN product_transaction pt ON pt.transaction_id = t.id" +
            "INNER JOIN product p ON pt.product_id = p.id" +
            "WHERE t.pic_id = ?1"
            ,nativeQuery = true)
    List<Transaction> findByPicId(BigInteger id);

    @Query(value = "SELECT * FROM transaction t" +
            "INNER JOIN employee e ON t.pic_id = e.id" +
            "INNER JOIN product_transaction pt ON pt.transaction_id = t.id" +
            "INNER JOIN product p ON pt.product_id = p.id" +
            "WHERE t.timestamp > ?1 AND t.timestamp <= ?2"
            ,nativeQuery = true)
    List<Transaction> findByTransactionDate(Date startDate, Date endDate);


}
