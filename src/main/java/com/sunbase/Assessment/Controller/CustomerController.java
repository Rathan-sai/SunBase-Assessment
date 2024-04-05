package com.sunbase.Assessment.Controller;

import com.sunbase.Assessment.Exceptions.CustomerNotFoundException;
import com.sunbase.Assessment.Model.Customer;
import com.sunbase.Assessment.RequestDto.CustomerRequestDto;
import com.sunbase.Assessment.ResponseDto.CustomerResponseDto;
import com.sunbase.Assessment.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        CustomerResponseDto createdCustomer = customerService.createCustomer(customerRequestDto);
        return new ResponseEntity("Hi " + createdCustomer.getFirstName() + " " + createdCustomer.getLastName() + " Thank You for adding in our community. please check your details\n" + createdCustomer, HttpStatus.ACCEPTED);
    }

    @GetMapping("/find-by-search/{search}")
    public ResponseEntity getCustomersBy(@PathVariable("search") String search,@RequestParam("value") String value) {
        List<CustomerResponseDto> customers = customerService.getCustomersBy(search, value);
        return new ResponseEntity(customers, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity getCustomerById(@PathVariable int customerId) {
        CustomerResponseDto customer;
        try {
            customer = customerService.getCustomerById(customerId);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(customer, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCustomerById/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable int customerId, @RequestBody CustomerRequestDto customer) {
        CustomerResponseDto updatedCustomer;
        try {
            updatedCustomer = customerService.updateCustomer(customerId, customer);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(updatedCustomer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable int customerId) {
        CustomerResponseDto res;
        try {
            res = customerService.deleteCustomer(customerId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(res, HttpStatus.ACCEPTED);
    }
}
