/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsClient
 * Author:   Pony
 * Date:     2019/12/10 14:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.search.client;


import com.leyou.item.api.GoodsApi;

import org.springframework.cloud.openfeign.FeignClient;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Pony
 * @create 2019/12/10
 * @since 1.0.0
 */
@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {

}