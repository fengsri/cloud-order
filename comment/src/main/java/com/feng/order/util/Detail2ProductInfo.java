package com.feng.order.util;

import com.feng.order.vo.OrderVo;
import com.feng.order.vo.ProductInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/7 18:29
 * @Version V1.0
 */
public class Detail2ProductInfo {
    public static List<ProductInfo> get(OrderVo orderVo){
        List<ProductInfo> productInfos = orderVo.getDetailList().stream().map(detail -> {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductId(detail.getProductId());
            productInfo.setCount(detail.getCount());
            return productInfo;
        }).collect(Collectors.toList());
        return productInfos;
    }

}
