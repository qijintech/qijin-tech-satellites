package tech.qijin.satellites.order.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tech.qijin.satellites.order.db.model.OrderSummary;
import tech.qijin.satellites.order.db.model.OrderSummaryExample;

public interface OrderSummaryMapper {
    long countByExample(OrderSummaryExample example);

    int deleteByExample(OrderSummaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderSummary record);

    int insertSelective(OrderSummary record);

    List<OrderSummary> selectByExample(OrderSummaryExample example);

    OrderSummary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderSummary record, @Param("example") OrderSummaryExample example);

    int updateByExample(@Param("record") OrderSummary record, @Param("example") OrderSummaryExample example);

    int updateByPrimaryKeySelective(OrderSummary record);

    int updateByPrimaryKey(OrderSummary record);
}