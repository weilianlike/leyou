package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
/**
 * 〈一句话功能简述〉<br>
 * 〈品牌管理Mapper〉
 *
 * @author Pony
 * @create 2019/11/26
 * @since 1.0.0
 */
@Transactional //加事物 两个表新增要么全部成功要么全部失败
public interface BrandMapper extends Mapper<Brand> {

    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand(category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertBrandAndCategory(@Param("cid") Long cid, @Param("bid") Long bid);
}
