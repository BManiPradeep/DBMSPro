package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    public final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/product/createProduct")
    public Product CreateProduct(@RequestBody Product product){
//        return product.getProductName();
        return productService.CreateProduct(product);
    }

    @PostMapping("/product/UpdateProduct")
    public String UpdateProduct(@RequestBody Long id,Product product){
        return productService.UpdateProduct(id,product);
    }

    @PostMapping("/product/addQuantity/{id}/addQuantity")
    public String AddProductQuantity(@RequestBody @PathVariable Long id,Long increment){
        return productService.AddProductQuantity(id,increment);

    }
}
