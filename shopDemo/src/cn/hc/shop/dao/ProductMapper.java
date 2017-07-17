package cn.hc.shop.dao;

import cn.hc.shop.entities.Product;
import cn.hc.shop.entities.ProductCondition;
import cn.hc.shop.entities.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //最热商品
	List<Product> selectProductsByHot();

	//根据一级菜单查询商品分页
	List<Product> selectPageByCid(@Param("cid") Integer cid, @Param("begin") int begin, @Param("limit") int limit);
	//根据一级菜单查询商品  总数
	int countByCid(Integer cid);

	//根据二级菜单查询商品分页
	List<Product> selectPageByCsid(@Param("csid") Integer csid, @Param("begin") int begin, @Param("limit") int limit);
	//根据二级菜单查询商品 总数
	int countByCsid(@Param("csid") Integer csid);
	//多条件查询商品
	List<Product> selectPageByCondition(@Param("pc") ProductCondition pc, @Param("begin") int begin, @Param("limit") int limit);
	//多条件查询商品 总数
	int countByCondition(@Param("pc") ProductCondition pc);

	//最新商品
	List<Product> selectProductsByPdate();
}