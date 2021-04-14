package com.DexAPI.Service;

import com.DexAPI.Entity.Item;
import com.DexAPI.Repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //  this annotation makes marks class as spring boot service
public class ItemService 
{

    @Autowired // dependency injection annotation 
    private ItemRepository itemRepository; // instance variable will be injected with @autowired annotation
     
    /*SERVICES*/

     // get all 
     public List<Item> getAllItems(Integer collectionId)
     {
        return itemRepository.findItemsByCollectionId(collectionId);

    }
    // get by id
    public Item getItemById(Integer id)
    {
        
        return itemRepository.findById(id).get();
    }
    //ADD ITEM
    public void addItem(Item item)
    {
        itemRepository.save(item);
	}

	// REMOVE ITEM
    public void deleteItem(Item item){
        itemRepository.delete(item);
	}

	// REMOVE BY ID
    public void deleteItemById(Integer id)
    {
        itemRepository.deleteById(id);
	}
    // update item
    public void updateItem(Item item)
    {
       itemRepository.save(item);
       
	}

    
}
