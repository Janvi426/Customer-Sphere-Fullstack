package net.javaproject.cms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaproject.cms.dto.CustomerDto;
import net.javaproject.cms.entity.Customer;
import net.javaproject.cms.exception.ResourseNotFoundException;
import net.javaproject.cms.mapper.CustomerMapper;
import net.javaproject.cms.repository.CustomerRepository;
import net.javaproject.cms.service.CustomerService;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

   private CustomerRepository customerRepository;
   @Override
   public CustomerDto createCustomer(CustomerDto customerDto) {
      
      Customer customer = CustomerMapper.mapCustomer(customerDto);
      Customer savedCustomer = customerRepository.save(customer);

      return CustomerMapper.mapCustomerDto(savedCustomer);
   }
   @Override
   public CustomerDto getCustomerById(Long customerId) {
      
      Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> 
                  new ResourseNotFoundException("Customer is not exist at id : " + customerId));
        
         return CustomerMapper.mapCustomerDto(customer);
  
      }
   @Override
   public List<CustomerDto> getAllCustomers() {
      
      List<Customer> customers = customerRepository.findAll();

      return customers.stream().map((customer) -> CustomerMapper.mapCustomerDto(customer))
               .collect(Collectors.toList());
   }
   @Override
   public CustomerDto updateCustomer(Long customerId, CustomerDto updatedCustomer) {
      Customer customer = customerRepository.findById(customerId).orElseThrow(
         () -> new ResourseNotFoundException("Customer is not exist at id : " + customerId)
      );

      customer.setFirstName(updatedCustomer.getFirstName());
      customer.setLastName(updatedCustomer.getLastName());
      customer.setEmail(updatedCustomer.getEmail());

      Customer updatedCustomerObj = customerRepository.save(customer);

      return CustomerMapper.mapCustomerDto(updatedCustomerObj);
   }
   @Override
   public void deleteCustomer(Long customerId) {
      
      Customer customer = customerRepository.findById(customerId).orElseThrow(
         () -> new ResourseNotFoundException("Customer is not exist at id : " + customerId)
      );

      customerRepository.deleteById(customerId);
   }

}
