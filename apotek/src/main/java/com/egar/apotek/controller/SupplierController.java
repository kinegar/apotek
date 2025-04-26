package com.egar.apotek.controller;

import com.egar.apotek.dto.EmployeeDTO;
import com.egar.apotek.dto.SupplierDTO;
import com.egar.apotek.service.EmployeeService;
import com.egar.apotek.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private SupplierService supplierService;
    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> save(@RequestBody SupplierDTO supplierDTO){
        SupplierDTO response = supplierService.save(supplierDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> findAll(){
        return ResponseEntity.ok(supplierService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getById(@PathVariable BigInteger id){
        return ResponseEntity.ok(supplierService.findById(id));
    }
}
