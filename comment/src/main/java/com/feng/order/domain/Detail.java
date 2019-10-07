package com.feng.order.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:23
 * @Version V1.0
 */
@Data
@Entity
public class Detail  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer orderId;
    private Integer count;
}
