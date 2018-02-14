package com.example.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shoppingcart.models.Item;
import com.example.shoppingcart.repos.ItemRepository;

@Service
public class ShoppingCartService {
	@Autowired
	ItemRepository itemRepository;

	List<Item> shoppingCart = new ArrayList<Item>();

	public List<Item> getItems() {
		List<Item> shoppingCart = new ArrayList<Item>();
		this.itemRepository.findAll().forEach(x -> shoppingCart.add(x));
		return shoppingCart;
		
	}
	
	public Item getItemById(int id) {
		return this.itemRepository.findOne(id);
		//return shoppingCart.stream().filter(x -> x.getId() == id).findFirst().get();
	}

	public void addItem(Item i) {
		/*
		 * Item item = new Item(); // adding items to list item.setId(i.getId());
		 * item.setName(i.getName()); item.setPrice(i.getPrice());
		 * 
		 * shoppingCart.add(item);
		 */
		this.itemRepository.save(i);
	}

	public void deleteItemById(int id) {
		/*Item item = this.getItemById(id);
		shoppingCart.remove(item);		
		return shoppingCart;*/
		Item item=this.itemRepository.findOne(id);
		this.itemRepository.delete(item);
		
		
	}
	
	public void updateItem(Item i) {
		Item item= this.getItemById(i.getId());
		item.setName(i.getName());
		item.setPrice(i.getPrice());
		this.itemRepository.save(item);
	}

}
