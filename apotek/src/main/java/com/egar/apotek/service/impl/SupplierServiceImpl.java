package com.egar.apotek.service.impl;

import com.egar.apotek.dto.SupplierDTO;
import com.egar.apotek.entity.Supplier;
import com.egar.apotek.mapper.SupplierMapper;
import com.egar.apotek.repository.SupplierRepository;
import com.egar.apotek.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    private SupplierMapper supplierMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper){
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.convertToEntity(supplierDTO);
        supplierRepository.save(supplier);
        supplierDTO.setId(supplier.getId());
        return supplierDTO;
    }

    @Override
    public List<SupplierDTO> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return supplierMapper.convertToDTOList(suppliers);
    }

    @Override
    public SupplierDTO findById(BigInteger id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()){
            return supplierMapper.convertToDTO(supplier.get());
        }else {
            throw new RuntimeException("Supplier not found with id - " + id);
        }
    }
}
