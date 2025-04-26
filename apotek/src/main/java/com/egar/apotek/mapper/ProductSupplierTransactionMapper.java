package com.egar.apotek.mapper;

import com.egar.apotek.dto.ProductSupplierTransactionDTO;
import com.egar.apotek.entity.Product;
import com.egar.apotek.entity.ProductSupplierTransaction;
import com.egar.apotek.entity.Supplier;
import com.egar.apotek.repository.ProductRepository;
import com.egar.apotek.repository.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductSupplierTransactionMapper {
    private final ModelMapper modelMapper;
    private ProductRepository productRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public ProductSupplierTransactionMapper(ModelMapper modelMapper,ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        configureMapper();
    }

    private void configureMapper() {
        modelMapper.addMappings(
                new PropertyMap<ProductSupplierTransactionDTO, ProductSupplierTransaction>() {
                    @Override
                    protected void configure() {
                        skip(destination.getSupplier());
                        skip(destination.getProduct());
                    }
                }
        );
        modelMapper.addMappings(
                new PropertyMap<ProductSupplierTransaction,ProductSupplierTransactionDTO>() {
                    @Override
                    protected void configure() {
                        skip(destination.getSupplier());
                        skip(destination.getProduct());
                    }
                }
        );
    }

    public ProductSupplierTransaction convertToEntity(ProductSupplierTransactionDTO productSupplierTransactionDTO){
        ProductSupplierTransaction productSupplierTransaction = modelMapper.map(productSupplierTransactionDTO,ProductSupplierTransaction.class);
        BigInteger productId = productSupplierTransactionDTO.getProduct();
        BigInteger supplierId = productSupplierTransactionDTO.getSupplier();
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            productSupplierTransaction.setProduct(product.get());
        }else{
            throw new RuntimeException("Product not found with id - " + productId);
        }
        Optional<Supplier> supplier = supplierRepository.findById(supplierId);
        if (supplier.isPresent()){
            productSupplierTransaction.setSupplier(supplier.get());
        }else {
            throw new RuntimeException("Supplier not found with id - " + supplierId);
        }
        return productSupplierTransaction;
    }

    public ProductSupplierTransactionDTO convertToDTO(ProductSupplierTransaction productSupplierTransaction){
        ProductSupplierTransactionDTO productSupplierTransactionDTO = modelMapper.map(productSupplierTransaction,ProductSupplierTransactionDTO.class);
        productSupplierTransactionDTO.setSupplier(productSupplierTransaction.getSupplier().getId());
        productSupplierTransactionDTO.setProduct(productSupplierTransaction.getProduct().getId());
        return productSupplierTransactionDTO;
    }

    public List<ProductSupplierTransactionDTO> convertToDTOList(List<ProductSupplierTransaction> productSupplierTransactions){
        List<ProductSupplierTransactionDTO> productSupplierTransactionDTOS = new ArrayList<>();
        for(ProductSupplierTransaction productSupplierTransaction : productSupplierTransactions){
            ProductSupplierTransactionDTO productSupplierTransactionDTO = modelMapper.map(productSupplierTransaction,ProductSupplierTransactionDTO.class);
            productSupplierTransactionDTO.setSupplier(productSupplierTransaction.getSupplier().getId());
            productSupplierTransactionDTO.setProduct(productSupplierTransaction.getProduct().getId());
            productSupplierTransactionDTOS.add(productSupplierTransactionDTO);
        }
        return productSupplierTransactionDTOS;
    }
}
