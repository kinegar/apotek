package com.egar.apotek.service;

import com.egar.apotek.dto.ProductDTO;

import java.math.BigInteger;
import java.util.List;

public interface ProductService {
    public ProductDTO save(ProductDTO productDTO);
    public List<ProductDTO> findAll();
    public ProductDTO findById(BigInteger id);
}
