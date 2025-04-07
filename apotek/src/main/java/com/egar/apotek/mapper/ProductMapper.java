package com.egar.apotek.mapper;

import com.egar.apotek.dto.EmployeeDTO;
import com.egar.apotek.dto.ProductDTO;
import com.egar.apotek.entity.Employee;
import com.egar.apotek.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ProductMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Product convertToEntity(ProductDTO productDTO){
        return  modelMapper.map(productDTO,Product.class);
    }

    public ProductDTO convertToDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> convertToDTOList(List<Product> products){
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product:products){
            ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
}
