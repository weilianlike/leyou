package com.leyou; /**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: com.leyou.LeyouItemServiceApplication
 * Author:   Pony
 * Date:     2019/11/26 19:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Pony
 * @create 2019/11/26
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.item.mapper")
public class LeyouItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouItemServiceApplication.class, args);
    }
}