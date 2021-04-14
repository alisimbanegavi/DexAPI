package com.DexAPI.Controller;

import com.DexAPI.Entity.Item;
import com.DexAPI.Entity.Collection;
import com.DexAPI.Service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController // this annotation marks class as spring boot rest api controller
public class ItemController {

  @Autowired
  private ItemService itemService; // we need to access the service methods here in the controller

  // GET LIST OF ALL COLLECTIBLES IN A PARTICULAR COLLECTION
  @RequestMapping("/catalogues/{id}/collections/{colId}/items")
  public List<Item> getAllItems(@PathVariable Integer colId) {
    return itemService.getAllItems(colId);
  }

  // GET ITEM BY ID
  @RequestMapping("/catalogues/{catalogueId}/collections/{id}/items/{itemId}") // can also write (method =
                                                                               // RequestMethod.GET, value="/items")
  public Item getItemById(@PathVariable Integer itemId) {
    return itemService.getItemById(itemId);
  }

  // ADD ITEM TO A COLLECTION
  @RequestMapping(method = RequestMethod.POST, value = "/catalogues/{catalogueId}/collections/{collectionId}/addItems")
  public void addItem(@RequestBody Item item, @PathVariable Integer collectionId) {
    item.setCollection(new Collection());
    itemService.addItem(item);
  }

  // UPDATE ITEM
  @RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
  public void updateItem(@RequestBody Item item, @PathVariable Integer id) {
    itemService.updateItem(item);
  }

  // DELETE Item
  @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
  public void deleteItemById(@PathVariable Integer id) {
    itemService.deleteItemById(id);
  }

}
