package com.feng.order.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:23
 * @Version V1.0
 */
@Data
@Entity
public class Order  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String orderNum;

    private String orderDate;

    private Double orderPrice;

    private String orderStatu;
}
