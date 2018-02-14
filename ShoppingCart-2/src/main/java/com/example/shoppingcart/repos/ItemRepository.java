package com.example.shoppingcart.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.shoppingcart.models.Item;



public interface ItemRepository extends CrudRepository<Item, Integer> {

}
