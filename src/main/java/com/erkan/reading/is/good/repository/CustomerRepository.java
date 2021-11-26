package com.erkan.reading.is.good.repository;

import com.erkan.reading.is.good.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
