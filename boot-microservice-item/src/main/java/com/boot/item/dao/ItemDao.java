package com.boot.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.item.pojo.Item;

@Mapper
public interface ItemDao {
	@Select("select * from item")
	List<Item> selectAllItem();
	
	@Select("select * from item where itemId = #{itemId}")
	Item selectItemById(Integer itemId);
}
