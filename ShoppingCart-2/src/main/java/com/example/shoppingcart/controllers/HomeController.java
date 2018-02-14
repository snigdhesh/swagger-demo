package com.example.shoppingcart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.models.Item;
import com.example.shoppingcart.services.ShoppingCartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
//@Api(value="HomeControllerAPI", produces=MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

	@Autowired
	ShoppingCartService shoppingCartService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	@ApiOperation("Display Home page")
	public String getHome() {
		return "Home Page";
	}

	@RequestMapping(value="/items", method=RequestMethod.GET)
	@ApiOperation("Gets all existing items")
	@ApiResponse(code = 200, message = "OK")
	public List<Item> getItems() {
		List<Item> shoppingCart = new ArrayList<Item>();
		shoppingCart = shoppingCartService.getItems();
		return shoppingCart;
	}
	
	@RequestMapping(value="/items/{id}",method=RequestMethod.GET)
	@ApiOperation("Get item by Id")
	public Item getItemById(@PathVariable int id) {
		return this.shoppingCartService.getItemById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/items")
	@ApiOperation("Create new item")
	public void addItem(@RequestBody Item item) {
		this.shoppingCartService.addItem(item);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
	@ApiOperation("Delete an item by id")
	public void deleteItemById(@PathVariable int id) {
		this.shoppingCartService.deleteItemById(id);
	}
	 
	@RequestMapping(method=RequestMethod.PUT, value="/items")
	@ApiOperation("Update an Item by Id")
	public void updateItem(@RequestBody Item item) {
		this.shoppingCartService.updateItem(item);
		
	}
}
