package com.onur.reading.repository;

import com.onur.reading.entity.Customer;
import com.onur.reading.entity.OrderHeader;
import com.onur.reading.enums.OrderHeaderStatus;
import com.onur.reading.enums.OrderLineStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
    @Query(
            value = "SELECT " +
                    "a.created_at as monthx, " +
                    "sum(b.quantity) as totalBookCount, " +
                    "count(distinct a.id) as totalOrderCount " +
                    "FROM reading.ORDER_HEADERS a, reading.ORDER_LINES b " +
                    "where a.id = b.header_id " +
                    "and a.customer_id = ?1 " +
                    "group by a.created_at",
            nativeQuery = true)
    List<StatisticForOneMonthConverter> generateMonthlyReport(Long customerId);

    Page<OrderHeader> findAllByCustomer(Customer customer, Pageable pageable);

    List<OrderHeader> findAllOrderHeaderByOrderStatusOrderByCreatedAtAsc(OrderHeaderStatus orderHeaderStatus);
}
