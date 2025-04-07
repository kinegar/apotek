package com.egar.apotek.controller;

import com.egar.apotek.dto.ProductDTO;
import com.egar.apotek.dto.TransactionDTO;
import com.egar.apotek.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

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


}
