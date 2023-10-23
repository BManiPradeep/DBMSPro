package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Repository.ProductRepository;
import com.example.DBMSPro.Service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private SecurityServices securityServices;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(SecurityServices securityServices, ProductRepository productRepository) {
        this.securityServices = securityServices;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String getProduct(Model model){
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
        List<Product> pr = productRepository.ListAllProducts();
        Map<Object, Object> products= new HashMap<Object,Object>();
        model.addAttribute("allproducts", pr);
        return "Products";
    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        System.out.println(product.getProductDescription());
        productRepository.AddProduct(product);
        System.out.println("Came to add Prdt post");
        return "redirect:/products";
    }


    @GetMapping("/product/delete/{ProductId}")
    public String deleteProductById(@PathVariable int ProductId){
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
        System.out.println("CAME TO PRDT Contr Del");
        int pr= productRepository.DeleteProduct(ProductId);
        return "redirect:/products";
    }


    //IMPLEMENT UPDATE PRODUCT

//    @GetMapping("/update_product/{prod_id}")
//    public String updateProduct( Model model, @PathVariable int prod_id)
//    {   String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
//        List<Product> pr=productRepository.ListProducts();
//        model.addAttribute("products",pr);
//        Product product= productRepository.GetProductById(prod_id);
//        model.addAttribute("product",product);
//        return "update_product";
//    }
}
