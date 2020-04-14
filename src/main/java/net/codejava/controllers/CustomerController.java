package net.codejava.controllers;

import net.codejava.repositories.Customer;
import net.codejava.repositories.Product;
import net.codejava.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @RequestMapping()
    public String viewHomePage(Model model) {
        //List<Product> listProducts = service.findByMadeIn("California");
        //Product listProducts = service.findByName("Product 3");
        //service.deleteByName("Test Product");
        List<Customer> listCustomer = service.listAll();
        model.addAttribute("listCustomer", listCustomer);
        return "customer";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        return "redirect:/customer";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_customer");
       Customer customer = service.get(id);
        mav.addObject("customer", customer);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/customer";
    }

}
