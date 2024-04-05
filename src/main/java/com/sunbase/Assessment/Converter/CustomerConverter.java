package com.sunbase.Assessment.Converter;

import com.sunbase.Assessment.Model.Customer;
import com.sunbase.Assessment.RequestDto.CustomerRequestDto;
import com.sunbase.Assessment.ResponseDto.CustomerResponseDto;

public class CustomerConverter {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .city(customerRequestDto.getCity())
                .phone(customerRequestDto.getPhone())
                .address(customerRequestDto.getAddress())
                .state(customerRequestDto.getState())
                .street(customerRequestDto.getStreet())
                .address(customerRequestDto.getAddress())
                .email(customerRequestDto.getEmail())
                .build();
    }

    public static CustomerRequestDto customerToCustomerRequestDto(Customer customer){
        return CustomerRequestDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .city(customer.getCity())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .state(customer.getState())
                .street(customer.getStreet())
                .email(customer.getEmail())
                .build();
    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .city(customer.getCity())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .state(customer.getState())
                .street(customer.getStreet())
                .email(customer.getEmail())
                .build();
    }
}
