package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

//    /**
//     * 根据菜品id删除对应的口味数据
//     * @param dishId
//     */
//    @Select("delete from dish_flavor where dish_id = #{dishId}")
//    void deleteByDishId(Long dishId);

    void deleteByDishId(List<Long> ids);
    //因为要用到动态sql，所以写到映射文件里面去
}