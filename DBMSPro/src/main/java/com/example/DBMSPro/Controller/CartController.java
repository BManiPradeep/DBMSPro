package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Cart;
import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Repository.CartRepository;
import com.example.DBMSPro.Repository.ProductRepository;
import com.example.DBMSPro.Service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    SecurityServices securityServices;
    CartRepository cartRepository;
    ProductRepository productRepository;

    @Autowired
    public CartController(SecurityServices securityServices, CartRepository cartRepository, ProductRepository productRepository) {
        this.securityServices = securityServices;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/cart")
    public String cart(Model model){
        int user_id= Math.toIntExact(securityServices.findLoggedInUser().getId());
        List<Cart> cart = cartRepository.GetCart(user_id);
        Map<Object, Object> cartProducts = new HashMap<Object,Object>();
        int cart_total = 0;
        for (Cart cartProduct : cart) {
            Product product = productRepository.GetProductById(cartProduct.getProd_id());
            cartProducts.put(cartProduct, product);
            cart_total += (int) (product.getPrice() * cartProduct.getProd_quantity());
        }

        model.addAttribute("cart", cart);
        model.addAttribute("cartProducts", cartProducts);
        model.addAttribute("cart_total",cart_total);
        return "cart";
    }

    @GetMapping("/addToCart/{prod_id}")
    public String addToCart(@PathVariable int prod_id )
    {
        int user_id= Math.toIntExact(securityServices.findLoggedInUser().getId());
        int ct= cartRepository.AddToCart(prod_id,user_id);
        return "redirect:/cart";
    }
}
