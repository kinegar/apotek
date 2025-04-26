package com.egar.apotek.controller;

import com.egar.apotek.dto.ProductSupplierTransactionDTO;
import com.egar.apotek.service.ProductSupplierTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product_supplier_transaction")
public class ProductSupplierTransactionController {
    private ProductSupplierTransactionService productSupplierTransactionService;

    @Autowired
    public ProductSupplierTransactionController(ProductSupplierTransactionService productSupplierTransactionService){
        this.productSupplierTransactionService = productSupplierTransactionService;
    }

    @PostMapping
    public ResponseEntity<ProductSupplierTransactionDTO> save(@RequestBody ProductSupplierTransactionDTO productSupplierTransactionDTO){
        return ResponseEntity.ok(productSupplierTransactionService.save(productSupplierTransactionDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSupplierTransactionDTO> findById(@PathVariable BigInteger id){
        return ResponseEntity.ok(productSupplierTransactionService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductSupplierTransactionDTO>> findAll(){
        return ResponseEntity.ok(productSupplierTransactionService.findAll());
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<List<ProductSupplierTransactionDTO>> findBySupplierId(@PathVariable BigInteger id){
        return ResponseEntity.ok(productSupplierTransactionService.findBySupplierId(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductSupplierTransactionDTO>> findByProductId(@PathVariable BigInteger id){
        return ResponseEntity.ok(productSupplierTransactionService.findByProductId(id));
    }

    @GetMapping("/date")
    public ResponseEntity<List<ProductSupplierTransactionDTO>> findByTransactionDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        return ResponseEntity.ok(productSupplierTransactionService.findByTransactionDate(startDate,endDate));
    }
}
