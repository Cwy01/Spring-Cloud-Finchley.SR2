package com.groovy.controller

import javax.annotation.Resource

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.groovy.pojo.Book
import com.groovy.service.BookService

@RestController
class BookController {

    @Resource
    BookService service;

    @RequestMapping('/books')
    List<Book> findAll() {
		print('所有数据：'+service.findAll())
        service.findAll()
    }
}
