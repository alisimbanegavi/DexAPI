package com.DexAPI.Repository;

import com.DexAPI.Entity.Catalogue;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// data access by extending CRUDRepository <Entity,data Type of the primary key( @id)> interface.
public interface CatalogueRepository extends CrudRepository<Catalogue, Integer> {

    // Finds all catalogues owned by a user
    @Query(value = "SELECT * FROM users_catalogue  inner join catalogue on catalogue.catalogue_id=users_catalogue.catalogue_user_id WHERE users_catalogue.user_id = :userID", nativeQuery = true)
    public List<Catalogue> findCataloguesByUserID(Integer userID);

    //// Searching for catalogue using keywords in description as search key
    @Query(value = "SELECT * FROM catalogue WHERE `description` LIKE LOWER(CONCAT('%',:description, '%'))", nativeQuery = true)
    public List<Catalogue> findCataloguesByDescription(String description);
}