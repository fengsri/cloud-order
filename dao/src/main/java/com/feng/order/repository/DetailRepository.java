package com.feng.order.repository;


import com.feng.order.domain.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:40
 * @Version V1.0
 */
@Repository
public interface DetailRepository extends JpaRepository<Detail,Integer> {

}
