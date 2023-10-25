package com.example.DBMSPro.Controller;
import com.example.DBMSPro.Models.Employee;
import com.example.DBMSPro.Models.Order;
import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.EmployeeRepository;
import com.example.DBMSPro.Repository.OrderRepository;
import com.example.DBMSPro.Repository.UserRepository;
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
public class OrderController {
    private SecurityServices securityServices;
    private OrderRepository orderRepository;
    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderController(SecurityServices securityServices, OrderRepository orderRepository, EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.securityServices = securityServices;
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/Orders")
    public String getOrders(Model model){
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
        System.out.println("CAME INTO FUNC");
        List<Order> ord = orderRepository.findAllOrders();
        Map<Object, Object> employee= new HashMap<Object,Object>();
        Map<Object, Object> users= new HashMap<Object,Object>();
        for(Order eachOrder : ord) {
            String emp_name=employeeRepository.GetEmployee(eachOrder.getEmp_id()).getEmp_fname();
            employee.put(eachOrder,emp_name);
            String user_name=userRepository.getUserById(eachOrder.getUser_id()).getUsername();
            users.put(eachOrder,user_name);
        }
        System.out.println("CAME TO ADMIN ORDERS");
        model.addAttribute("employee",employee);
        model.addAttribute("users", users);
        model.addAttribute("orders", ord);
        return "orders";
    }

    @GetMapping("/update_order/{order_id}")
    public String updateOrder(Model model, @PathVariable int order_id)
    {
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }

        List<Employee> emp=employeeRepository.ListEmployees();
        model.addAttribute("emps",emp);
        Order order= orderRepository.getOrderById(order_id);
        model.addAttribute("orders",order);
        return "update_order";
    }

    @PostMapping("/update_order/{order_id}")
    public String updateOrder(@ModelAttribute("orders") Order order, Model model, @PathVariable int order_id)
    {
        int o= orderRepository.updateOrder(order, order_id);
        if(o==0)  return "error";
        return "redirect:/admin/Orders";
    }


    @GetMapping("/Orders")
    public String getUserOrders(Model model){
//        String user_type=securityServices.findLoggedInUser().getUser_type();
//        if(user_type.equals("USER"))
//        {      return "login";  }
//        System.out.println("CAME INTO FUNC");
        User user=securityServices.findLoggedInUser();
        if(user==null){
           return  "login";
        }
        int id= Math.toIntExact(user.getId());
        List<Order> ord = orderRepository.getOrdersByUserId(id);
        Map<Object, Object> employee= new HashMap<Object,Object>();
        Map<Object, Object> users= new HashMap<Object,Object>();
        for(Order eachOrder : ord) {
            String emp_name=employeeRepository.GetEmployee(eachOrder.getEmp_id()).getEmp_fname();
            employee.put(eachOrder,emp_name);
            String user_name=userRepository.getUserById(eachOrder.getUser_id()).getUsername();
            users.put(eachOrder,user_name);
        }
        model.addAttribute("employee",employee);
        model.addAttribute("users", users);
        model.addAttribute("orders", ord);
        return "myorders";
    }

    @GetMapping("/viewOrder/{id}")
    public String viewOrder(@PathVariable int id){
        return "viewOrder";
    }

}
