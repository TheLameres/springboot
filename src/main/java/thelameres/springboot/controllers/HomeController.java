package thelameres.springboot.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import thelameres.springboot.models.Customer;
import thelameres.springboot.services.CustomerService;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        LoggerFactory.getLogger(HomeController.class).info("GET FROM /");
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> listCustomer = customerService.listAll();
        modelAndView.addObject("listCustomer", listCustomer);
        return modelAndView;
    }

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        customerService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = customerService.findByKeyword(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }
}
