package com.example.DBMSPro.Controller;

import com.example.DBMSPro.FileUploadUtil;
import com.example.DBMSPro.Models.Order;
import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Repository.OrderRepository;
import com.example.DBMSPro.Repository.ProductRepository;
import com.example.DBMSPro.Service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private SecurityServices securityServices;
    private ProductRepository productRepository;

    private OrderRepository orderRepository;

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
    public String addProduct(@ModelAttribute Product product,@RequestParam("productImage") MultipartFile multipartFile,Model model) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        product.setImage_path(fileName);
//        int pr=1;
        int pr=productRepository.AddProduct(product);
        if(pr==0)  return "error";
        String uploadDir = "productImages/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        System.out.println("Came to add Prdt post");
        return "redirect:/products";
    }


    @GetMapping("/product/delete/{ProductId}")
    public String deleteProductById(@PathVariable int ProductId){
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
        int pr= productRepository.DeleteProduct(ProductId);

        return "redirect:/products";
    }

    @GetMapping("/update_product/{ProductId}")
    public String updateProduct( Model model, @PathVariable int ProductId)
    {
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
        Product product= productRepository.GetProductById(ProductId);
        model.addAttribute("product",product);
        return "update_product";
    }


    @PostMapping("/update_product/{ProductId}")
    public String updateProductPOSTHandler(@ModelAttribute Product product, @PathVariable int ProductId,
                                           @RequestParam("productImage") MultipartFile multipartFile, Model model) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        product.setImage_path(fileName);

        int pr=productRepository.UpdateProduct(product, ProductId);

        if(pr==0)  return "error";
        String uploadDir = "productImages/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Product> product = productRepository.FindByNameContaining(query);
        Map<Object, Object> products= new HashMap<Object,Object>();
        model.addAttribute("products", product);
        return "home";  // This should be the name of your search results view
    }
}
