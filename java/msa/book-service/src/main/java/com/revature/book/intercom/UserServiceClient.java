package com.revature.book.intercom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping(path = "/feign", produces = "text/plain")
    String testFeignClient();

}
