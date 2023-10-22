package com.example.DBMSPro.Service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

//    private final ProductsRepository productsRepository;
//
//    @Autowired
//    public ProductService(ProductsRepository productsRepository) {
//        this.productsRepository = productsRepository;
//    }
//
//
//    public List<Product> getAllProducts() {
//        return productsRepository.findAll();
//    }
//
//    public Product CreateProduct(Product product) {
//        productsRepository.save(product);
//        return product;
//    }
//
//    public String UpdateProduct(Long id,Product updatedProduct) {
//        Product existingProduct = productsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + id));
//        existingProduct.setProductName(updatedProduct.getProductName());
//        existingProduct.setProductDescription(updatedProduct.getProductDescription());
//        existingProduct.setPrice(updatedProduct.getPrice());
//        existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
//        existingProduct.setSupplierId(updatedProduct.getSupplierId());
//        existingProduct.setExpiryDate(updatedProduct.getExpiryDate());
//
//        productsRepository.save(existingProduct);
//        return "Product Updated Successfully";
//    }
//
//    public String AddProductQuantity(Long id,Long increment) {
//        Product existingProduct = productsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + id));
//        existingProduct.setStockQuantity(existingProduct.getStockQuantity()+increment);
//        return "Quantity Added Successfully";
//    }
}
