package tech.qijin.satellites.order.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tech.qijin.satellites.order.db.model.OrderDeliveryInfo;
import tech.qijin.satellites.order.db.model.OrderDeliveryInfoExample;

public interface OrderDeliveryInfoMapper {
    long countByExample(OrderDeliveryInfoExample example);

    int deleteByExample(OrderDeliveryInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDeliveryInfo record);

    int insertSelective(OrderDeliveryInfo record);

    List<OrderDeliveryInfo> selectByExample(OrderDeliveryInfoExample example);

    OrderDeliveryInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDeliveryInfo record, @Param("example") OrderDeliveryInfoExample example);

    int updateByExample(@Param("record") OrderDeliveryInfo record, @Param("example") OrderDeliveryInfoExample example);

    int updateByPrimaryKeySelective(OrderDeliveryInfo record);

    int updateByPrimaryKey(OrderDeliveryInfo record);
}