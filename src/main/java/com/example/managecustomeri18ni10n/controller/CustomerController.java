package com.example.managecustomeri18ni10n.controller;

import com.example.managecustomeri18ni10n.model.Customer;
import com.example.managecustomeri18ni10n.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("customers", iCustomerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("customers", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customers", customerOptional.get());
        return modelAndView;

    }

    @PostMapping("/edit")
    public String edit(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        iCustomerService.remove(id);
        return "redirect:/customers";
    }
}
