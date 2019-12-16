package com.leyou.auth.UserClient;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}