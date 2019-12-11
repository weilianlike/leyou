/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BrandController
 * Author:   Pony
 * Date:     2019/11/27 10:37
 * Description: 分类管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈品牌管理controller〉
 *
 * @author Pony
 * @create 2019/11/27
 * @since 1.0.0
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

  /*
             queryBrandByPage.method=根据查询条件分页并排序查询品牌信息

  key=&page=1&rows=5&sortBy=id&desc=false  参数
            key: this.search, // 搜索条件
            page: this.pagination.page,// 当前页
            rows: this.pagination.rowsPerPage,// 每页大小
            sortBy: this.pagination.sortBy,// 根据哪个字段排序
            desc: this.pagination.descending// 是否降序
    */
  @GetMapping("page")
  public ResponseEntity<Object> queryBrandByPage(
            @RequestParam(value = "key",required = false) String key,//不知道key的默认值是啥 所以写required = false
            @RequestParam(value = "page",defaultValue = "1") Integer page,//默认第一页
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,//总共分五页
            @RequestParam(value = "sortBy",required = false) String sortBy,//不知道根据什么字段进行排序
            @RequestParam(value = "desc",required = false) Boolean desc//不知道升序还是降序
    ){
      PageResult<Brand> result=this.brandService.queryBrandByPage(key,page,rows,sortBy,desc);
      /*
        判断result以及result中的内容是否为空
      * */
        if(CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    /*
        - 请求方式：POST
         - 请求路径：/brand
        - 请求参数：brand对象，外加商品分类的id数组cids
        - 返回值：无，只需要响应状态码

     */
    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids){
        this.brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 新增商品
     * @param cid
     *请求方式：GET
     *
     * 请求路径：/brand/cid/{cid}
     *
     * 请求参数：cid
     *
     * 响应数据：品牌集合
     *
     */
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandsByCid(@PathVariable("cid")Long cid){
        List<Brand> brands = this.brandService.queryBrandsByCid(cid);
        if (CollectionUtils.isEmpty(brands)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brands);
    }

    @GetMapping("{id}")
    public ResponseEntity<Brand> queryBrandByCid(@PathVariable("id")Long id){
        Brand brand = this.brandService.queryBrandById(id);
        if (brand==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brand);
    }
}