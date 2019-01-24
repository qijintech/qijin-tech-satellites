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
import tech.qijin.satellites.item.db.model.ItemInfo;
import tech.qijin.satellites.item.db.model.ItemInfoExample;

public interface ItemInfoMapper {
    @SelectProvider(type=ItemInfoSqlProvider.class, method="countByExample")
    long countByExample(ItemInfoExample example);

    @DeleteProvider(type=ItemInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemInfoExample example);

    @Delete({
        "delete from item_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_info (title, introduction, ",
        "status, channel, ",
        "env, valid, ctime, ",
        "utime)",
        "values (#{title,jdbcType=VARCHAR}, #{introduction,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{channel,jdbcType=TINYINT}, ",
        "#{env,jdbcType=TINYINT}, #{valid,jdbcType=TINYINT}, #{ctime,jdbcType=TIMESTAMP}, ",
        "#{utime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ItemInfo record);

    @InsertProvider(type=ItemInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ItemInfo record);

    @SelectProvider(type=ItemInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="channel", property="channel", jdbcType=JdbcType.TINYINT),
        @Result(column="env", property="env", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ItemInfo> selectByExample(ItemInfoExample example);

    @Select({
        "select",
        "id, title, introduction, status, channel, env, valid, ctime, utime",
        "from item_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="channel", property="channel", jdbcType=JdbcType.TINYINT),
        @Result(column="env", property="env", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    ItemInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemInfo record, @Param("example") ItemInfoExample example);

    @UpdateProvider(type=ItemInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemInfo record, @Param("example") ItemInfoExample example);

    @UpdateProvider(type=ItemInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemInfo record);

    @Update({
        "update item_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "introduction = #{introduction,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "channel = #{channel,jdbcType=TINYINT},",
          "env = #{env,jdbcType=TINYINT},",
          "valid = #{valid,jdbcType=TINYINT},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "utime = #{utime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemInfo record);
}