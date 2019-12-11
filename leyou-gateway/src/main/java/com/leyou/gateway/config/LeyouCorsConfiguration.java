/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LeyouCorsConfiguration
 * Author:   Pony
 * Date:     2019/11/27 9:13
 * Description: 解决跨域问题(过滤器)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 〈一句话功能简述〉<br>
 * 〈解决跨域问题(过滤器)〉
 *
 * @author Pony
 * @create 2019/11/27
 * @since 1.0.0
 */
@SuppressWarnings("all")
@Configuration
public class LeyouCorsConfiguration {
    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1) 允许跨域的域名,如果要携带cookie,不要写*，否则cookie就无法使用了,*代表所有域名都可以跨域访问
        config.addAllowedOrigin("http://manage.leyou.com");
        config.addAllowedOrigin("http://www.leyou.com");
        //2) 允许携带Cookie信息
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedMethod("*");//*代表以下所有的方法
        //config.addAllowedMethod("OPTIONS");
        //config.addAllowedMethod("HEAD");
        //config.addAllowedMethod("GET");
        //config.addAllowedMethod("PUT");
        //config.addAllowedMethod("POST");
        //config.addAllowedMethod("DELETE");
        //config.addAllowedMethod("PATCH");
        // 4）允许携带任何头信息
        config.addAllowedHeader("*");

        //2.添加映射路径，我们拦截一切请求(初始化cors配置源对象)
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}