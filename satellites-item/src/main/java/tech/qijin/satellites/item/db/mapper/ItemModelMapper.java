package tech.qijin.satellites.item.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import tech.qijin.satellites.item.db.model.ItemModel;
import tech.qijin.satellites.item.db.model.ItemModelExample;

public interface ItemModelMapper {
    @SelectProvider(type=ItemModelSqlProvider.class, method="countByExample")
    long countByExample(ItemModelExample example);

    @DeleteProvider(type=ItemModelSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemModelExample example);

    @Delete({
        "delete from item_model",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_model (item_id, title, ",
        "original_price, member_price, ",
        "discount_price, channel, ",
        "env, valid, ctime, ",
        "utime)",
        "values (#{itemId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{originalPrice,jdbcType=DECIMAL}, #{memberPrice,jdbcType=DECIMAL}, ",
        "#{discountPrice,jdbcType=DECIMAL}, #{channel,jdbcType=TINYINT}, ",
        "#{env,jdbcType=TINYINT}, #{valid,jdbcType=TINYINT}, #{ctime,jdbcType=TIMESTAMP}, ",
        "#{utime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ItemModel record);

    @InsertProvider(type=ItemModelSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ItemModel record);

    @SelectProvider(type=ItemModelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="member_price", property="memberPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="channel", property="channel", jdbcType=JdbcType.TINYINT),
        @Result(column="env", property="env", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ItemModel> selectByExample(ItemModelExample example);

    @Select({
        "select",
        "id, item_id, title, original_price, member_price, discount_price, channel, env, ",
        "valid, ctime, utime",
        "from item_model",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="member_price", property="memberPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="channel", property="channel", jdbcType=JdbcType.TINYINT),
        @Result(column="env", property="env", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    ItemModel selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemModelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemModel record, @Param("example") ItemModelExample example);

    @UpdateProvider(type=ItemModelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemModel record, @Param("example") ItemModelExample example);

    @UpdateProvider(type=ItemModelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemModel record);

    @Update({
        "update item_model",
        "set item_id = #{itemId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "original_price = #{originalPrice,jdbcType=DECIMAL},",
          "member_price = #{memberPrice,jdbcType=DECIMAL},",
          "discount_price = #{discountPrice,jdbcType=DECIMAL},",
          "channel = #{channel,jdbcType=TINYINT},",
          "env = #{env,jdbcType=TINYINT},",
          "valid = #{valid,jdbcType=TINYINT},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "utime = #{utime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemModel record);
}