package com.boot.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.boot.mongodb.pojo.User;
import com.boot.mongodb.dao.IUserDao;

@Service
public class UserService implements IUserService{

    @Autowired
    private MongoTemplate mongoTemplate;
	
    
	@Override
	public void saveUser(User user) {
		mongoTemplate.save(user);
		
	}

	@Override
	public User findUserByName(String name) {
		Query query=new Query(Criteria.where("name").is(name));
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
	}

	@Override
	public void updateUser(User user) {
		Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("name", user.getName()).set("age", user.getAge());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,User.class);
		
	}

	@Override
	public void deleteUserById(Integer id) {
		Query query=new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query,User.class);
	}
    
    
}