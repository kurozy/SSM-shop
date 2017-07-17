package cn.hc.shop.dao;

import cn.hc.shop.entities.CategorySecond;
import cn.hc.shop.entities.CategorySecondExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategorySecondMapper {
    int countByExample(CategorySecondExample example);

    int deleteByExample(CategorySecondExample example);

    int deleteByPrimaryKey(Integer csid);

    int insert(CategorySecond record);

    int insertSelective(CategorySecond record);

    List<CategorySecond> selectByExample(CategorySecondExample example);

    CategorySecond selectByPrimaryKey(Integer csid);

    int updateByExampleSelective(@Param("record") CategorySecond record, @Param("example") CategorySecondExample example);

    int updateByExample(@Param("record") CategorySecond record, @Param("example") CategorySecondExample example);

    int updateByPrimaryKeySelective(CategorySecond record);

    int updateByPrimaryKey(CategorySecond record);

	List<CategorySecond> selectCsByCid(Integer cid);
}