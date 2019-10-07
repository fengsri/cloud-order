package com.feng.order.client;

import com.feng.order.domain.Product;
import com.feng.order.vo.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/1 16:53
 * @Version V1.0
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/product/list")
    List<Product> getByIds(@RequestParam("ids")List<Integer> listId);

    @PostMapping("/product/reduce")
    void reduceProductCount(@RequestBody List<ProductInfo> productInfoList);

}
