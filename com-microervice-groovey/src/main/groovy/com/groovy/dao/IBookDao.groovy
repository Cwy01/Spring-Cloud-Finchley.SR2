package com.groovy.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.groovy.pojo.Book

@Repository
interface IBookDao extends JpaRepository<Book,Long>{
    
}