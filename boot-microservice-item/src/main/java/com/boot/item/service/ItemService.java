package com.boot.item.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.item.pojo.Item;

@Component
public interface ItemService {
	List<Item> selectAllItem();
	Item selectItemById(Integer itemId);
}
