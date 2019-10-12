package com.feng.order.repository;


import com.feng.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:40
 * @Version V1.0
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {


}
