package com.feng.order.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/7 17:21
 * @Version V1.0
 */
@Data
public class ProductInfo {

    @NotNull(message = "参数错误")
    private Integer productId;

    @NotNull(message = "参数错误")
    @Min(value = 0,message = "参数错误")
    private Integer count;
}
