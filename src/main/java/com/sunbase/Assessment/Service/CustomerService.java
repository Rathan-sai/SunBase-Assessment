package com.sunbase.Assessment.Service;

import com.sunbase.Assessment.Converter.CustomerConverter;
import com.sunbase.Assessment.Exceptions.CustomerNotFoundException;
import com.sunbase.Assessment.Model.Customer;
import com.sunbase.Assessment.Repository.CustomerRepository;
import com.sunbase.Assessment.RequestDto.CustomerRequestDto;
import com.sunbase.Assessment.ResponseDto.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository userRepository) {
        this.customerRepository = userRepository;
    }
    
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = CustomerConverter.customerRequestDtoToCustomer(customerRequestDto);
        CustomerResponseDto responseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        responseDto.setMessage("Customer added Successfully");
        customerRepository.save(customer);
        return responseDto;
    }



    public CustomerResponseDto getCustomerById(int customerId) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer;
        Customer customer;
        try {
            optionalCustomer = customerRepository.findById(customerId);
            customer = optionalCustomer.get();
        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        CustomerResponseDto responseDto =  CustomerConverter.customerToCustomerResponseDto(customer);
        responseDto.setMessage("Customer Found");
        return responseDto;
    }

    public List<CustomerResponseDto> getCustomersBy(String search, String value) {
        List<Customer> userList;
        switch (search) {
            case "city": {
                userList = customerRepository.findByCity(value);
                break;
            }
            case "phone": {
                userList = customerRepository.findByPhone(value);
                break;
            }
            case "firstName": {
                userList = customerRepository.findByfirstName(value);
                break;
            }
            case "email": {
                userList = customerRepository.findByEmail(value);
                break;
            }
            default: {
                userList=customerRepository.findAll();
            }
        }

        //else I'll have the value

        //let's Convert the  Every User to UserResponce dto using our Transformer Function and I've actually Used
        List<CustomerResponseDto> userResponceDtos = userList.stream()
                .map(ele -> CustomerConverter.customerToCustomerResponseDto(ele))
                .collect(Collectors.toList());



        return userResponceDtos;
    }

    public CustomerResponseDto updateCustomer(int customerId, CustomerRequestDto customer) throws CustomerNotFoundException {

        Optional<Customer> optionalCustomer;
        Customer existingCustomer;
        try {
            optionalCustomer = customerRepository.findById(customerId);
        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        existingCustomer = optionalCustomer.get();
        // Update customer fields here
        if(customer.getFirstName() != null){
            existingCustomer.setFirstName(customer.getFirstName());
        }
        if(customer.getStreet() != null){
            existingCustomer.setStreet(customer.getStreet());
        }if(customer.getLastName() != null){
            existingCustomer.setLastName(customer.getLastName());
        }if(customer.getAddress() != null){
            existingCustomer.setAddress(customer.getAddress());
        }if(customer.getEmail() != null){
            existingCustomer.setEmail(customer.getEmail());
        }if(customer.getCity() != null){
            existingCustomer.setCity(customer.getCity());
        }if(customer.getState() != null){
            existingCustomer.setState(customer.getState());
        }if(customer.getPhone() != null){
            existingCustomer.setPhone(customer.getPhone());
        }

        customerRepository.save(existingCustomer);

        CustomerResponseDto responseDto = CustomerConverter.customerToCustomerResponseDto(existingCustomer);
        responseDto.setMessage("User With name:" + customer.getFirstName() + " has been Updated");

        return responseDto;
    }

    public CustomerResponseDto deleteCustomer(int customerId) throws CustomerNotFoundException {
        Optional<Customer> existingCustomer;
        try {
            existingCustomer = customerRepository.findById(customerId);
        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        Customer user = existingCustomer.get();
        customerRepository.delete(user);
        CustomerResponseDto responceDto = CustomerConverter.customerToCustomerResponseDto(user);
        responceDto.setMessage("User with id:" + user.getId() + " has been deleted Successfully!!");
        return responceDto;
    }

}
