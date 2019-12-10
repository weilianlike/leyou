/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BrandService
 * Author:   Pony
 * Date:     2019/11/27 10:35
 * Description: 分类管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈品牌管理service〉
 *
 * @author Pony
 * @create 2019/11/27
 * @since 1.0.0
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /*
     * 根据查询条件分页并排序查询品牌信息
     * */
    public PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        // 初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        // 根据name模糊查询，或者根据首字母查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        // 添加分页条件
        PageHelper.startPage(page, rows);

        // 添加排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }

        List<Brand> brands = this.brandMapper.selectByExample(example);
        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     */
    public void saveBrand(Brand brand, List<Long> cids) {

        //先新增brand
        Boolean flag = this.brandMapper.insertSelective(brand) == 1;//sql语句影响条数是否为1


        // 在新增中间表
        cids.forEach(cid -> {
            this.brandMapper.insertBrandAndCategory(cid, brand.getId());
        });
        }
    /**
     * 新增商品
     *
     * @param cid
     */
    public List<Brand> queryBrandsByCid(Long cid) {

        return this.brandMapper.selectBrandByCid(cid);
    }
    }
