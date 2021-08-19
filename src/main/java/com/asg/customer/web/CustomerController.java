package com.asg.customer.web;

import com.asg.customer.entity.Customer;
import com.asg.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("showForm")
    public String showStudentForm(Customer customer) {
        return "add-customer";
    }

    @GetMapping("list")
    public String students(Model model) {
        model.addAttribute("customer", this.customerService.getAllCustomers());
        return "index";
    }

    @PostMapping("add")
    public String addStudent( Customer customer, BindingResult result) {
        if(result.hasErrors()) {
            return "add-customer";
        }

        this.customerService.saveCustomer(customer);
       return "redirect:list";
    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = this.customerService.getCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id : " + id));

        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, Customer customer, BindingResult result, Model model) {
        if(result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }

        customerService.saveCustomer(customer);

        model.addAttribute("customer", this.customerService.getAllCustomers());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable ("id") long id, Model model) {

        Customer customer = this.customerService.getCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id : " + id));

        this.customerService.deleteCustomer(customer);
        model.addAttribute("customer", this.customerService.getAllCustomers());
        return "index";

    }
}
