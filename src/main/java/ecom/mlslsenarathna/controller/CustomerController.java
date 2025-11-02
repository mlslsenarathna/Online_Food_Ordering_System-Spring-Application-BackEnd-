package ecom.mlslsenarathna.controller;

import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getById/{custId}")
    public CustomerDTO getCustomer(@PathVariable String custId){
        return customerService.getCustomer(custId);

    }
    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();

    }
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.add(customerDTO);
    }
    @PutMapping("/Update{customerDTO}")
    public void updateByID(@RequestBody CustomerDTO customerDTO){
        customerService.updateByID(customerDTO);
    }
    @DeleteMapping("/deleteById/{customerId}")
    public void deleteById(@PathVariable String customerId){
        customerService.deleteById(customerId);

    }


}
