package com.sky.mapper;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderSubmitVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
    /**
     *  插入订单数据
     * @param orders
     */
    void insert(Orders orders);

}
