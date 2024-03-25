package net.javaproject.cms.service;

import java.util.List;

import net.javaproject.cms.dto.CustomerDto;

public interface CustomerService {
   CustomerDto createCustomer(CustomerDto customerDto);

   CustomerDto getCustomerById(Long customerId);

   List<CustomerDto> getAllCustomers();

   CustomerDto updateCustomer(Long customerId, CustomerDto updatedCustomer);

   void deleteCustomer(Long customerId);


}
