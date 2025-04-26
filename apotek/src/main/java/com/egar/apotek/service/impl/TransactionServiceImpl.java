package com.egar.apotek.service.impl;

import com.egar.apotek.dto.ProductTransactionDTO;
import com.egar.apotek.dto.TransactionDTO;
import com.egar.apotek.dto.TransactionReportDTO;
import com.egar.apotek.dto.TransactionReportUnitSoldDTO;
import com.egar.apotek.entity.Product;
import com.egar.apotek.entity.ProductSupplierTransaction;
import com.egar.apotek.entity.ProductTransaction;
import com.egar.apotek.entity.Transaction;
import com.egar.apotek.mapper.TransactionMapper;
import com.egar.apotek.repository.ProductRepository;
import com.egar.apotek.repository.ProductSupplierTransactionRepository;
import com.egar.apotek.repository.TransactionRepository;
import com.egar.apotek.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionMapper transactionMapper;
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;
    private ProductSupplierTransactionRepository productSupplierTransactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionMapper transactionMapper,TransactionRepository transactionRepository,ProductRepository productRepository,ProductSupplierTransactionRepository productSupplierTransactionRepository ){
        this.transactionMapper = transactionMapper;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.productSupplierTransactionRepository = productSupplierTransactionRepository;
    }

    @Override
    public TransactionDTO save(TransactionDTO transactionDTO) {

        Transaction transaction = transactionMapper.convertToEntity(transactionDTO);
        transaction.setTimestamp(new Date());

        //get list productuct
        List<ProductTransaction> productTransactions = new ArrayList<>();
        for (ProductTransactionDTO productTransactionDTO : transactionDTO.getProductTransactions()){
            ProductTransaction productTransaction = new ProductTransaction();
            productTransaction.setId(productTransactionDTO.getId());
            productTransaction.setStock(productTransactionDTO.getStock());
            Optional<Product> product = productRepository.findById(productTransactionDTO.getProduct());
            if(product.isPresent()){
                productTransaction.setProduct(product.get());
            }else {
                throw new RuntimeException("Product not found with id - " + productTransactionDTO.getProduct());
            }
            productTransactions.add(productTransaction);
        }
        transaction.setProductTransactions(productTransactions);

        BigDecimal totalPrice = BigDecimal.ZERO;
        for(ProductTransaction productTransaction : productTransactions){
            BigDecimal soldPrice = productTransaction.getProduct().getPrice();
            productTransaction.setSoldPrice(soldPrice);
            totalPrice = totalPrice.add(soldPrice.multiply(BigDecimal.valueOf(productTransaction.getStock())));
//            productTransaction.setTransaction(transaction);
        }
        transaction.setTotalPrice(totalPrice);

        transactionRepository.save(transaction);
        transactionDTO.setTimestamp(transaction.getTimestamp());
        transactionDTO.setId(transaction.getId());
        transactionDTO.setTotalPrice(totalPrice);
        List<ProductTransactionDTO> productTransactionDTOS = transactionDTO.getProductTransactions();
        for (int i = 0; i < productTransactionDTOS.size(); i++) {
            productTransactionDTOS.get(i).setId(productTransactions.get(i).getId());
            productTransactionDTOS.get(i).setSoldPrice(productTransactions.get(i).getSoldPrice());
        }
        return transactionDTO;
    }

    @Override
    public TransactionDTO findById(BigInteger id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            return transactionMapper.convertToDTO(transaction.get());
        }else {
            throw new RuntimeException("Transaction not found with id - " + id);
        }
    }

    @Override
    public List<TransactionDTO> findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactionMapper.convertToDTOList(transactions);
    }

    @Override
    public List<TransactionDTO> findByPicId(BigInteger id) {
        List<Transaction> transactions = transactionRepository.findByPicId(id);
        return transactionMapper.convertToDTOList(transactions);
    }

    @Override
    public List<TransactionDTO> findByTransactionDate(Date startDate, Date endDate) {
        List<Transaction> transactions = transactionRepository.findByTransactionDate(startDate,endDate);
        return transactionMapper.convertToDTOList(transactions);
    }

    @Override
    public TransactionReportDTO transactionReport(Date startDate, Date endDate) {
        TransactionReportDTO transactionReportDTO = new TransactionReportDTO();
        //get transaction total
        Integer nTransactions= transactionRepository.countByTransactionDate(startDate,endDate);
        transactionReportDTO.setNumberOfTransaction(nTransactions);
        //get unit sold and total sold

        List<TransactionReportUnitSoldDTO> unitSold = new ArrayList<>();
        Map<String ,BigDecimal> unitSoldMap = new HashMap<>();
        BigDecimal gross = BigDecimal.ZERO;

        //get transactionSupplier
        List<ProductSupplierTransaction> productSupplierTransactions = productSupplierTransactionRepository.findByTransactionDate(startDate,endDate);
        BigDecimal expense = BigDecimal.ZERO;
        for(ProductSupplierTransaction productSupplierTransaction : productSupplierTransactions){
            productSupplierTransaction.getProduct();
            productSupplierTransaction.getStock();
            productSupplierTransaction.getSoldPrice();
        }
        BigDecimal nett = gross.subtract(expense);

        return null;
    }
}
