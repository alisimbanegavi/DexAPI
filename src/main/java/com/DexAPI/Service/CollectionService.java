package com.DexAPI.Service;

import com.DexAPI.Entity.Collection;
import com.DexAPI.Repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service // this annotation makes marks class as spring boot service
public class CollectionService 
{
    @Autowired // dependency injection annotation
    private CollectionRepository collectionRepository; // instance variable will be injected with @autowired annotation

    /* SERVICES */

    // get all collections in a catalogue
    // RENAMED FROM getAllCollections() IN YACINE'S CODE
    public List<Collection> getAllCollectionsInCatalogue(Integer catalogueId){
        return collectionRepository.findCollectionsByCatalogueId(catalogueId);
    }

    // GET COLLECTION BY ID
    public Collection getCollectionById(Integer id)
    {
        return collectionRepository.findById(id).get();
    }

    //add collection 
    public void addCollection(Collection c)
    {
        collectionRepository.save(c);
	}

    //remove
    public void deleteCollection(Collection c)
    {
        collectionRepository.delete(c);
	}

    // remove by id
    public void deleteCollectionById(Integer id)
    {
       collectionRepository.deleteById(id);
	}
    // update
    
    public void updateCollection(Collection c){
       collectionRepository.save(c); // same method used for adding new collection, if collection  exists in table, it ll overrride 
       
	}

    // update collection description
    public void updateCollectionDescription(Integer id, String description)
    {
        Collection col  = collectionRepository.findById(id).get();
        col.setDescription(description);
        collectionRepository.save(col);
    }
}
