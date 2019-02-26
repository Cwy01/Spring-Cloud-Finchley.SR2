package com.groovy.pojo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book implements Serializable{
	
	@Id
	@GeneratedValue
    int id
    String title
    String author

    Book() {
    }

    Book(int id, String title, String author) {
        this.id = id
        this.title = title
        this.author = author
    }
}
