package com.feng.order.service.impl;

import com.feng.order.client.ProductClient;
import com.feng.order.domain.Detail;
import com.feng.order.domain.Order;
import com.feng.order.domain.Product;
import com.feng.order.repository.DetailRepository;
import com.feng.order.repository.OrderRepository;
import com.feng.order.service.OrderService;
import com.feng.order.util.Detail2ProductInfo;
import com.feng.order.util.RandomNumberUtil;
import com.feng.order.vo.OrderVo;
import com.feng.order.vo.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/2 20:26
 * @Version V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Override
    @Transactional
    public boolean  createOrder(OrderVo orderVo) {
        //查询商品
        List<Integer> integerList = orderVo.getDetailList().stream().
                map(Detail::getProductId).collect(Collectors.toList());
        List<Product> productList = productClient.getByIds(integerList);

        //计算总价
        Double sum = 0.0;
        for (Product product:productList){
            for(Detail detail:orderVo.getDetailList()){
                if(product.getId().equals(detail.getProductId())){
                    sum+=detail.getCount()*product.getPrice();
                }
            }
        }

        //扣库存
        List<ProductInfo> productInfoList = Detail2ProductInfo.get(orderVo);
        productClient.reduceProductCount(productInfoList);

        //订单入库
        String orderNum = RandomNumberUtil.getOrderNumber();
        Order order = new Order();
        order.setOrderDate("2019-12-11");
        order.setOrderNum(orderNum);
        order.setOrderPrice(sum);
        order.setOrderStatu("支付");
        Order orderResult = orderRepository.save(order);

        //详情入库
        for(Detail detail:orderVo.getDetailList()){
            detail.setOrderId(orderResult.getId());
            detailRepository.save(detail);
        }

        return true;
    }


   
}
