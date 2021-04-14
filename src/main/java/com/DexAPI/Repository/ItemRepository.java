package com.DexAPI.Repository;

import com.DexAPI.Entity.Catalogue;
import com.DexAPI.Entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// data access by extending CRUDRepository <Entity,data Type of the primary key( @id)> interface.
public interface ItemRepository extends CrudRepository<Item, Integer> {
  // Searching for items using collection id that those items belong to as search
  // key
  @Query(value = "SELECT * FROM collection_item WHERE `item_collection_id` = :collID", nativeQuery = true)
  public List<Item> findItemsByCollectionId(Integer collID);

  // Searching for item using keywords in collection name as search key
  @Query(value = "SELECT * FROM item i WHERE i.`item_name` LIKE LOWER(CONCAT('%',:name, '%'))", nativeQuery = true)
  public List<Item> findByName(String name);

  //// Searching for items using keywords in description as search key
  @Query(value = "SELECT * FROM item WHERE `description` LIKE LOWER(CONCAT('%',:description, '%'))", nativeQuery = true)
  public List<Item> findItemsByDescription(String description);

  // TIME BASED SEARCH
  // QUERIES-----------------------------------------------------------
  // Searching for item using date as search key
  @Query(value = "SELECT * FROM item i WHERE i.`item_date` = :itemDate", nativeQuery = true)
  public List<Item> findByItemDate(String itemDate);

  // Searching for item with origin date before specified date
  @Query(value = "SELECT * FROM item i WHERE i.`item_date` < :dateBefore AND i.`item_date` = :dateBefore", nativeQuery = true)
  public List<Item> findBeforeDate(String dateBefore);

  // Searching for item with origin date after specified date
  @Query(value = "SELECT * FROM item i WHERE i.`item_date` > :dateAfter AND i.`item_date` = :dateAfter", nativeQuery = true)
  public List<Item> findAfterDate(String dateAfter);
  // -----------------------------------------------------------------------------------------
}
