package com.groovy.service

import org.springframework.stereotype.Service

import com.groovy.pojo.Book

interface BookService {
    List<Book> findAll()
	Book save(Book book)
}
