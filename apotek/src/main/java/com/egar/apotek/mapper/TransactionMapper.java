package com.egar.apotek.mapper;

import com.egar.apotek.dto.ProductTransactionDTO;
import com.egar.apotek.dto.TransactionDTO;
import com.egar.apotek.entity.Employee;
import com.egar.apotek.entity.ProductTransaction;
import com.egar.apotek.entity.Transaction;
import com.egar.apotek.repository.EmployeeRepository;
import com.egar.apotek.repository.ProductTransactionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionMapper {
    private final ModelMapper modelMapper;
    private ProductTransactionRepository productTransactionRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public TransactionMapper(ModelMapper modelMapper,ProductTransactionRepository productTransactionRepository, EmployeeRepository employeeRepository){
        this.modelMapper = modelMapper;
        this.productTransactionRepository = productTransactionRepository;
        this.employeeRepository = employeeRepository;
        configureMapper();
    }

    private void configureMapper() {
        modelMapper.addMappings(
                new PropertyMap<Transaction, TransactionDTO>() {
                    @Override
                    protected void configure() {
                        skip(destination.getPic());
                    }
                }
        );
        modelMapper.addMappings(
                new PropertyMap<TransactionDTO, Transaction>() {
                    @Override
                    protected void configure() {
                        skip(destination.getPic());
                        skip(destination.getProductTransactions());
                    }
                }
        );
        modelMapper.addMappings(
                new PropertyMap<ProductTransaction, ProductTransactionDTO>() {
                    @Override
                    protected void configure() {
                        skip(destination.getProduct());
                    }
                }
        );
        modelMapper.addMappings(
                new PropertyMap<ProductTransactionDTO, ProductTransaction>() {
                    @Override
                    protected void configure() {
                        skip(destination.getProduct());
                    }
                }
        );
    }

    public Transaction convertToEntity(TransactionDTO transactionDTO){
        Transaction transaction = modelMapper.map(transactionDTO,Transaction.class);
        BigInteger picId = transactionDTO.getPic();
        Optional<Employee> employee =employeeRepository.findById(picId);
        if(employee.isPresent()){
            transaction.setPic(employee.get());
        }else{
            throw new RuntimeException("Employee not found with id - " + picId);
        }
//        for(ProductTransaction productTransaction : transaction.getProductTransactions()){
//            productTransaction.setTransaction(transaction);
//        }
        return transaction;

    }

    public TransactionDTO convertToDTO(Transaction transaction){
        TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
        transactionDTO.setPic(transaction.getPic().getId());
        return transactionDTO;
    }

    public List<TransactionDTO> convertToDTOList(List<Transaction> transactions){
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for(Transaction transaction : transactions){
            TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
            transactionDTO.setPic(transaction.getPic().getId());
            for (int i = 0; i < transactionDTO.getProductTransactions().size(); i++) {
                transactionDTO.getProductTransactions().get(i).setProduct(transaction.getProductTransactions().get(i).getProduct().getId());
            }
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }
}
