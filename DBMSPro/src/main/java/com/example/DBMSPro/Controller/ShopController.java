package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Repository.ProductRepository;
import com.example.DBMSPro.Service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShopController {

    SecurityServices securityServices;
    ProductRepository productRepository;

    @Autowired
    public ShopController(SecurityServices securityServices, ProductRepository productRepository) {
        this.securityServices = securityServices;
        this.productRepository = productRepository;
    }

    @GetMapping("/shop")
    public String getShopList(Model model){
        // model.addAttribute("user",securityServices.findLoggedInUser());
        model.addAttribute("username",securityServices.findLoggedInUsername());
        List<Product> pr= productRepository.ListProducts();
        model.addAttribute("products",pr);
        return "shop";
    }

    @GetMapping("/shop/view_product/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productRepository.GetProductById(Math.toIntExact(id));

        if (product != null) {
            model.addAttribute("product", product);
            return "showProduct"; // Assuming you have a Thymeleaf template named "view_product.html"
        } else {
            return "redirect:/products"; // Redirect to the product list if product is not found
        }
    }

}
