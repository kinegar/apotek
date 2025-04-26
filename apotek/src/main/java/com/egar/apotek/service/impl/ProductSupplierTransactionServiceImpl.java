package com.egar.apotek.service.impl;

import com.egar.apotek.dto.ProductSupplierTransactionDTO;
import com.egar.apotek.entity.ProductSupplierTransaction;
import com.egar.apotek.mapper.ProductSupplierTransactionMapper;
import com.egar.apotek.repository.ProductSupplierTransactionRepository;
import com.egar.apotek.service.ProductSupplierTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSupplierTransactionServiceImpl implements ProductSupplierTransactionService {
    private ProductSupplierTransactionRepository productSupplierTransactionRepository;
    private ProductSupplierTransactionMapper productSupplierTransactionMapper;

    @Autowired
    public ProductSupplierTransactionServiceImpl(
            ProductSupplierTransactionRepository productSupplierTransactionRepository,
            ProductSupplierTransactionMapper productSupplierTransactionMapper){
        this.productSupplierTransactionRepository = productSupplierTransactionRepository;
        this.productSupplierTransactionMapper = productSupplierTransactionMapper;
    }

    @Override
    public ProductSupplierTransactionDTO save(ProductSupplierTransactionDTO productSupplierTransactionDTO) {
        ProductSupplierTransaction productSupplierTransaction = productSupplierTransactionMapper.convertToEntity(productSupplierTransactionDTO);
        productSupplierTransaction.setTimestamp(new Date());
        productSupplierTransactionRepository.save(productSupplierTransaction);
        productSupplierTransactionDTO.setId(productSupplierTransaction.getId());
        productSupplierTransactionDTO.setTimestamp(productSupplierTransaction.getTimestamp());
        return productSupplierTransactionDTO;
    }

    @Override
    public ProductSupplierTransactionDTO findById(BigInteger id) {
        Optional<ProductSupplierTransaction> productSupplierTransaction = productSupplierTransactionRepository.findById(id);
        if (productSupplierTransaction.isPresent()){
            return productSupplierTransactionMapper.convertToDTO(productSupplierTransaction.get());

        }else {
            throw new RuntimeException("ProProductSupplierTransactionduct not found with id - " + id);
        }
    }

    @Override
    public List<ProductSupplierTransactionDTO> findAll() {
        List<ProductSupplierTransaction> productSupplierTransactions = productSupplierTransactionRepository.findAll();
        return productSupplierTransactionMapper.convertToDTOList(productSupplierTransactions);
    }

    @Override
    public List<ProductSupplierTransactionDTO> findBySupplierId(BigInteger id) {
        List<ProductSupplierTransaction> productSupplierTransactions = productSupplierTransactionRepository.findBySupplierId(id);
        return productSupplierTransactionMapper.convertToDTOList(productSupplierTransactions);
    }

    @Override
    public List<ProductSupplierTransactionDTO> findByProductId(BigInteger id) {
        List<ProductSupplierTransaction> productSupplierTransactions = productSupplierTransactionRepository.findByProductId(id);
        return productSupplierTransactionMapper.convertToDTOList(productSupplierTransactions);
    }

    @Override
    public List<ProductSupplierTransactionDTO> findByTransactionDate(Date startDate, Date endDate) {
        List<ProductSupplierTransaction> productSupplierTransactions = productSupplierTransactionRepository.findByTransactionDate(startDate,endDate);
        return productSupplierTransactionMapper.convertToDTOList(productSupplierTransactions);
    }
}
