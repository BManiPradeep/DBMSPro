package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Cart;
import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.CartRepository;
import com.example.DBMSPro.Repository.OrderRepository;
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

    @Autowired
    SecurityServices securityServices;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

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
    public String addToCart(@PathVariable long prod_id )
    {
        long user_id= (securityServices.findLoggedInUser().getId());
        long ct= cartRepository.AddToCart(prod_id,user_id);
        return "redirect:/cart";
    }

    @GetMapping("/cart/removeItem/{ProductId}")
    public String DeletefromCart(@PathVariable long ProductId){
        long id=securityServices.findLoggedInUser().getId();
        cartRepository.DeleteFromCart(ProductId,id);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout()
    {   int user_id= Math.toIntExact(securityServices.findLoggedInUser().getId());
        List<Cart> productsInCart = cartRepository.GetCart(user_id);
        int no_of_items=0;
        for (Cart cartProduct : productsInCart) {
            int prod_quantity= Math.toIntExact(productRepository.GetProductById(cartProduct.getProd_id()).getStockQuantity());
            int cart_quantity=cartProduct.getProd_quantity()  ;
            if(cart_quantity>prod_quantity) {
                return "redirect:/cart?error=true";
            }
            no_of_items=no_of_items+1;
        }

        if(no_of_items==0)
        {
            return "redirect:/cart";
        }

        int o=orderRepository.addOrder(user_id);
        if(o==0)  return "error";

        for (Cart cartProduct : productsInCart) {
            productRepository.ReduceProductQuantity(cartProduct.getProd_quantity(),cartProduct.getProd_id());
        }
        int c= cartRepository.ClearCart(user_id);
        return "redirect:/cart?success=true";
    }
}
