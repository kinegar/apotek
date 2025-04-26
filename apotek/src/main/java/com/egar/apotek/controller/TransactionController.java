package com.egar.apotek.controller;

import com.egar.apotek.dto.ProductDTO;
import com.egar.apotek.dto.TransactionDTO;
import com.egar.apotek.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> save(@RequestBody TransactionDTO transactionDTO){
        TransactionDTO response = transactionService.save(transactionDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getById(@PathVariable BigInteger id){
        return ResponseEntity.ok(transactionService.findById(id));
    }

    @GetMapping("/pic/{id}")
    public ResponseEntity<List<TransactionDTO>> findByPic(@PathVariable BigInteger id){
        return ResponseEntity.ok(transactionService.findByPicId(id));
    }

    @GetMapping("/date")
    public ResponseEntity<List<TransactionDTO>> findByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        return ResponseEntity.ok(transactionService.findByTransactionDate(startDate,endDate));
    }
}
