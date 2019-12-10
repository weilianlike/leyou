package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodsController {
    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
    - 请求方式：GET
    - 请求路径：/spu/page
    - 请求参数：
    - page：当前页
    - rows：每页大小
    - key：过滤条件
    - saleable：上架或下架
    - 返回结果：商品SPU的分页信息。
     */
    @Autowired
    private GoodsService goodsService;

    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuBoByPage(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "saleable", required = false)Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows
    ){
        PageResult<SpuBo> pageResult = this.goodsService.querySpuBoByPage(key, saleable, page, rows);
        if(CollectionUtils.isEmpty(pageResult.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pageResult);
    }
    /**
     *
     * @param
     * @return void
     *
     */
    @PostMapping("goods")
    //通过@RequestBody注解来接收Json请求
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo){
        this.goodsService.saveGoods(spuBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *修改商品接口
     * @param
     * @return void
     *- 请求方式：PUT
     * - 请求路径：/
     * - 请求参数：Spu对象
     * - 返回结果：无
     */
    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo){
        this.goodsService.update(spuBo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     *查询SpuDetail接口
     * @param
     * @return void
     * - 请求方式：GET
     * - 请求路径：/spu/detail/{id}
     * - 请求参数：id，应该是spu的id
     * - 返回结果：SpuDetail对象
     */
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId")Long spuId){
        SpuDetail spuDetail = this.goodsService.querySpuDetailBySpuId(spuId);
        if (spuDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spuDetail);
    }
    /**
     *查询SpuDetail接口
     * @param
     * - 请求方式：Get
     * - 请求路径：/sku/list
     * - 请求参数：id，应该是spu的id
     * - 返回结果：sku的集合
     */
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkusBySpuId(@RequestParam("id")Long spuId){
        List<Sku> skus = this.goodsService.querySkusBySpuId(spuId);
        if (CollectionUtils.isEmpty(skus)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(skus);
    }
}