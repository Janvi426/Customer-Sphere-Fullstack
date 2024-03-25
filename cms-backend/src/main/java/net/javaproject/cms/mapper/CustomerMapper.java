package net.javaproject.cms.mapper;

import net.javaproject.cms.dto.CustomerDto;
import net.javaproject.cms.entity.Customer;

public class CustomerMapper {

   public static CustomerDto mapCustomerDto(Customer customer) {
      return new CustomerDto(
         customer.getId(),
         customer.getFirstName(),
         customer.getLastName(),
         customer.getEmail()
      );
   }

   public static Customer mapCustomer(CustomerDto customerDto) {
      return new Customer(
         customerDto.getId(),
         customerDto.getFirstName(),
         customerDto.getLastName(),
         customerDto.getEmail()
      );
   }

}
