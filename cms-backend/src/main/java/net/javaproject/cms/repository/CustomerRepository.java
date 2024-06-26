package net.javaproject.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaproject.cms.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
