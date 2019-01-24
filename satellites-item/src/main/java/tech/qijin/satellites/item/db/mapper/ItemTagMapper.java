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
import tech.qijin.satellites.item.db.model.ItemTag;
import tech.qijin.satellites.item.db.model.ItemTagExample;

public interface ItemTagMapper {
    @SelectProvider(type=ItemTagSqlProvider.class, method="countByExample")
    long countByExample(ItemTagExample example);

    @DeleteProvider(type=ItemTagSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemTagExample example);

    @Delete({
        "delete from item_tag",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_tag (item_id, channel, ",
        "env, valid, ctime, ",
        "utime)",
        "values (#{itemId,jdbcType=BIGINT}, #{channel,jdbcType=TINYINT}, ",
        "#{env,jdbcType=TINYINT}, #{valid,jdbcType=TINYINT}, #{ctime,jdbcType=TIMESTAMP}, ",
        "#{utime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ItemTag record);

    @InsertProvider(type=ItemTagSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ItemTag record);

    @SelectProvider(type=ItemTagSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="channel", property="channel", jdbcType=JdbcType.TINYINT),
        @Result(column="env", property="env", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ItemTag> selectByExample(ItemTagExample example);

    @Select({
        "select",
        "id, item_id, channel, env, valid, ctime, utime",
        "from item_tag",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="channel", property="channel", jdbcType=JdbcType.TINYINT),
        @Result(column="env", property="env", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    ItemTag selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemTagSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemTag record, @Param("example") ItemTagExample example);

    @UpdateProvider(type=ItemTagSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemTag record, @Param("example") ItemTagExample example);

    @UpdateProvider(type=ItemTagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemTag record);

    @Update({
        "update item_tag",
        "set item_id = #{itemId,jdbcType=BIGINT},",
          "channel = #{channel,jdbcType=TINYINT},",
          "env = #{env,jdbcType=TINYINT},",
          "valid = #{valid,jdbcType=TINYINT},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "utime = #{utime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemTag record);
}