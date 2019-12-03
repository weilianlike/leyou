/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SpecificationService
 * Author:   Pony
 * Date:     2019/12/3 12:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Pony
 * @create 2019/12/3
 * @since 1.0.0
 */
@Service
public class SpecificationService {
    @Autowired
private SpecGroupMapper specGroupMapper;


        /**
         * 根据分类id查询分组
         * @param cid
         * @return
         */
        public List<SpecGroup> queryGroupsByCid(Long cid) {
            SpecGroup specGroup = new SpecGroup();
            specGroup.setCid(cid);
            return this.specGroupMapper.select(specGroup);
        }
}