package com.egar.apotek.mapper;

import com.egar.apotek.dto.ProductDTO;
import com.egar.apotek.dto.SupplierDTO;
import com.egar.apotek.entity.Product;
import com.egar.apotek.entity.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Supplier convertToEntity(SupplierDTO supplierDTO){
        return  modelMapper.map(supplierDTO,Supplier.class);
    }

    public SupplierDTO convertToDTO(Supplier supplier){
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public List<SupplierDTO> convertToDTOList(List<Supplier> suppliers){
        List<SupplierDTO> supplierDTOS = new ArrayList<>();
        for (Supplier supplier: suppliers){
            SupplierDTO supplierDTO = modelMapper.map(supplier, SupplierDTO.class);
            supplierDTOS.add(supplierDTO);
        }
        return supplierDTOS;
    }
}
