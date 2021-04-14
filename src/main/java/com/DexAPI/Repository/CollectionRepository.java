package com.DexAPI.Repository;

import com.DexAPI.Entity.Catalogue;
import com.DexAPI.Entity.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// data access by extending CRUDRepository <Entity,data Type of the primary key( @id)> interface.
public interface CollectionRepository extends CrudRepository<Collection,Integer>
{
    // @Query(value = "SELECT * FROM collection col INNER JOIN catalogue cat ON col.`collection_catalogue_id` = cat.`catalogue_id`",nativeQuery = true)

    @Query(value = "SELECT * FROM catalogue_collection WHERE `collection_catalogue_id` = :catalogueID",nativeQuery = true)
    public List<Collection> findCollectionsByCatalogueId(Integer catalogueID);

    //// Searching for collections using keywords in description as search key
    @Query(value = "SELECT * FROM collection WHERE `description` LIKE LOWER(CONCAT('%',:description, '%'))", nativeQuery = true)
    public List<Collection> findCollectionsByDescription(String description);
}
