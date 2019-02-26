package com.groovy.service

import com.groovy.dao.IBookDao
import com.groovy.pojo.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class BookServiceImpl implements BookService{
	@Autowired
	private IBookDao bookDao
	
	@Override
	public List<Book> findAll(){
		bookDao.findAll()
	}

	@Override
	public Book save(Book book){
		bookDao.save(Book)
	}
}
