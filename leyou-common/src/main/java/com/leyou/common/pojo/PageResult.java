/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageResult
 * Author:   Pony
 * Date:     2019/11/27 10:02
 * Description: 分页结果集
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.common.pojo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈分页结果集〉
 *
 * @author Pony
 * @create 2019/11/27
 * @since 1.0.0
 */
public class PageResult<T> {
    private Long total;// 总条数
    private Integer totalPage;// 总页数
    private List<T> items;// 当前页数据


    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage=totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}