package com.erkan.reading.is.good.repository;

import com.erkan.reading.is.good.entity.Customer;
import com.erkan.reading.is.good.entity.OrderHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
    @Query(
            value = "SELECT to_char(a.created_at, 'MMYYYY') month, sum(amount) totalPurchasedAmount, count(b.id) totalBookCount, count(distinct a.id) totalOrderCount\n" +
                    "FROM EKO.ORDER_HEADERS a, EKO.ORDER_LINES b\n" +
                    "where a.id = b. header_id\n" +
                    "and a.customer_id = ?1\n" +
                    "group by to_char(a.created_at, 'MMYYYY')",
            nativeQuery = true)
    List<StatisticForOneMonthConverter> generateMonthlyReport(Long customerId);

    Page<OrderHeader> findAllByCustomer(Customer customer, Pageable pageable);
}
