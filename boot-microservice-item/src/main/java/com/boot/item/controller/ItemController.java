package com.boot.item.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.item.pojo.Item;
import com.boot.item.service.ItemServiceImpl;

@RestController
@RequestMapping("view/")
public class ItemController {
	private static final Logger LOG = Logger.getLogger(ItemController.class.getName());

	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	@GetMapping(value="item/")
	public List<Item> selectAllItem() {
		LOG.log(Level.INFO, "info is being called:ItemController selectAllItem");
		return itemServiceImpl.selectAllItem();
	}
	
	@GetMapping(value="item/{itemId}")
	public Item selectItemById(@PathVariable("itemId") Integer itemId) {
		LOG.log(Level.INFO, "info is being called:ItemController selectItemById");
		return itemServiceImpl.selectItemById(itemId);
	}
	
}