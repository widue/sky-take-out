package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrdersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务类, 定时处理订单状态
 */
@Component
@Slf4j
public class OrderTask {
    @Autowired
    private OrdersMapper ordersMapper;


    /**
     * 处理超时订单
     */
//    @Scheduled(cron = "0 * * * * ? ")//每分钟执行一次
//    @Scheduled(cron = "0/10 * * * * ? ")
    public void processTimeoutOrder(){
        log.info("处理超时订单,{}", LocalDateTime.now());

        // 查询超时订单
        List<Orders> ordersList = ordersMapper.getByStatusAndOrderTimeLT(Orders.PENDING_PAYMENT, LocalDateTime.now().plusMinutes(-15));

        if (ordersList != null && ordersList.size() > 0)
            for (Orders order : ordersList) {
                //更新订单状态
                Orders orders = Orders.builder()
                        .status(Orders.CANCELLED)
                        .cancelReason("订单超时，自动取消")
                        .cancelTime(LocalDateTime.now())
                        .build();
                ordersMapper.update(orders);
            }
    }

//    @Scheduled(cron = "0 0 1 * * ? ")
//    @Scheduled(cron = "0/8 * * * * ? ")
    public void processDeliveryOrder(){
        log.info("处理超时订单,{}", LocalDateTime.now());

        // 获取所有超时订单
        List<Orders> ordersList = ordersMapper.getByStatusAndOrderTimeLT(Orders.DELIVERY_IN_PROGRESS, LocalDateTime.now().plusHours(-1));

        if (ordersList != null && ordersList.size() > 0)
            for (Orders order : ordersList) {
                //更新订单状态
                Orders orders = Orders.builder()
                        .status(Orders.COMPLETED)
                        .build();
                ordersMapper.update(orders);
            }
    }




}
