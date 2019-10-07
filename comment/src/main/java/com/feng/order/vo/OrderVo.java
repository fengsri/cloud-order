package com.feng.order.vo;

import com.feng.order.domain.Detail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/2 20:16
 * @Version V1.0
 */
@Data
public class OrderVo {

    private Integer id;

    private String orderNum;

    private Date orderDate;

    private BigDecimal orderPrice;

    private String orderStatu;

    private List<Detail> detailList;

}
