package com.egar.apotek.service.impl;

import com.egar.apotek.dto.ProductDTO;
import com.egar.apotek.entity.Product;
import com.egar.apotek.mapper.ProductMapper;
import com.egar.apotek.repository.ProductRepository;
import com.egar.apotek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        productRepository.save(product);
        productDTO.setId(product.getId());
        return productDTO;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.convertToDTOList(products);
    }

    @Override
    public ProductDTO findById(BigInteger id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return productMapper.convertToDTO(product.get());
        }else {
            throw new RuntimeException("Product not found with id - " + id);
        }
    }
}
