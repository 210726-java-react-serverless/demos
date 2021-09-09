package com.revature.book.controllers;

import com.revature.book.intercom.UserServiceClient;
import com.revature.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/test", produces = "text/plain")
    public String test() {
        return "BookService works!";
    }


    @GetMapping(path = "/test-feign", produces = "text/plain")
    public String testFeign() {
        return bookService.testFeignClient("some-test-value");
    }

}
