package com.feng.order.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:23
 * @Version V1.0
 */
@Data
@Entity
public class Product  implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String type;
    private Double price;
}
