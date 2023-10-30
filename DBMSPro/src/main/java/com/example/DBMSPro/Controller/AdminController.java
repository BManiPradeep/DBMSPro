package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Models.Role;
import com.example.DBMSPro.Repository.ProductRepository;
import com.example.DBMSPro.Repository.UserRepository;
import com.example.DBMSPro.Service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    SecurityServices securityServices;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;




    @GetMapping("/admin")
    public String adminHome()
    {
        System.out.println("CAME TO ADMIN");
        long roleId=securityServices.findLoggedInUser().getRole().getRoleId();
        System.out.println(roleId);
        if(roleId!=1)
        {      return "login";  }


        return "Admin";
    }

    @GetMapping("/admin/Products")
    public String getProduct(Model model){
        String user_type=securityServices.findLoggedInUser().getUser_type();
        if(user_type.equals("USER"))
        {      return "login";  }
        List<Product> pr = productRepository.ListAllProducts();
        Map<Object, Object> products= new HashMap<Object,Object>();
        model.addAttribute("allproducts", pr);
        return "Products";
    }


}
