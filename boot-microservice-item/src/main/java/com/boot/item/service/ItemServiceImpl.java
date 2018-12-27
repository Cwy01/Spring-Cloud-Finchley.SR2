package com.boot.item.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.item.dao.ItemDao;
import com.boot.item.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService{
	private static final Logger LOG = Logger.getLogger(ItemService.class.getName());
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> selectAllItem() {
		LOG.log(Level.INFO, "info is being called:ItemServiceImpl selectAllItem");
		return itemDao.selectAllItem();
	}

	@Override
	public Item selectItemById(Integer itemId) {
		LOG.log(Level.INFO, "info is being called:ItemServiceImpl selectItemById");
		return itemDao.selectItemById(itemId);
	}
	
}
