package com.revature.spring_mvc.controllers;

import com.revature.spring_mvc.dtos.Credentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    public @ResponseBody String test() {
        return "/spring-mvc-demo/test/test1 works!";
    }

    @GetMapping("/test2")
    public @ResponseBody String test2() {
        return "/spring-mvc-demo/test/test2 works!";
    }

    @GetMapping("/test3")
    public @ResponseBody String test3(@RequestParam String someValue, @RequestParam("anotherValue") String whatever) {
        return "/spring-mvc-demo/test/test3 works! Provided values: " + someValue + " and " + whatever;
    }

    // Does not work due to ambiguous mapping (Spring container fails to load)
//    @GetMapping("/test3")
//    public @ResponseBody String test3() {
//        return "/spring-mvc-demo/test/test3 works! This endpoint doesn't accept request params";
//    }

    @GetMapping("/test4/{someValue}/{anotherValue}")
    public @ResponseBody String test4(@PathVariable String someValue, @PathVariable("anotherValue") String whatever) {
        return "/spring-mvc-demo/test/test4 works! Provided values: " + someValue + " and " + whatever;
    }

    @GetMapping("/test5")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void test5() {
        System.out.println("This will not be returned to the requester, but just printed to the web server output");
    }

    @GetMapping("/test6")
    public ResponseEntity<String> test6(@RequestParam boolean brewCoffee) {

        if (brewCoffee) {
            return new ResponseEntity<>("Did Thing.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Didn't do thing.", HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/test7")
    public @ResponseBody String test7(@RequestParam(required = false) String someValue) {
        if (someValue != null) {
            return "/spring-mvc-demo/test/test7 works! Provided value: " + someValue;
        } else {
            return "/spring-mvc-demo/test/test7 works! No value provided";
        }
    }

    @GetMapping("/test8")
    public void test8(HttpServletResponse resp) {
        System.out.println("test8 invoked!");
        resp.setStatus(204);
    }

    @GetMapping("/test9")
    public @ResponseBody String test9(@RequestHeader String someValue, @RequestHeader(value = "anotherValue", required = false) String whatever) {
        if (whatever != null) {
            return "/spring-mvc-demo/test/test7 works! Provided values: " + someValue + " and " + whatever;
        } else {
            return "/spring-mvc-demo/test/test7 works! Provided value: " + someValue;
        }
    }

    @GetMapping("/test10")
    public String test10() {
        return "index";
    }

    @PostMapping(value = "/test11", produces = "application/json", consumes = "application/json")
    public @ResponseBody Credentials test11(@RequestBody Credentials creds, HttpServletResponse resp) {
        resp.setHeader("Authorization", "Bearer aksjhdsuidhr2394k.suieygr82f8w784rt34.wwe8g72384rf");
        return creds;
    }

    @GetMapping("/test12")
    public void test12() {
        throw new RuntimeException("Another test");
    }



}
