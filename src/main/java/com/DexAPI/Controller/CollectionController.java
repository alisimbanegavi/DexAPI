package com.DexAPI.Controller;

import com.DexAPI.Entity.Catalogue;
import com.DexAPI.Entity.Collection;
import com.DexAPI.Repository.CatalogueRepository;
import com.DexAPI.Service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController // this annotation marks class as spring boot rest api contoller
public class CollectionController 
{

    @Autowired
    private CollectionService collectionService; // we need to access the service methods here in the controller

    /* CONTROLLER METHODS*/


    //GET LIST OF ALL COLLECTIONS BELONGING TO A PARTICULAR CATALOGUE ID 
    @RequestMapping("/catalogues/{id}/collections")
    public List<Collection> getAllCollections(@PathVariable Integer id) {
       return collectionService.getAllCollectionsInCatalogue(id);
    }

    //GET COLLECTION BY ID
    @RequestMapping(method = RequestMethod.GET, value="/collections/{id}")
    public Collection getCollectionById(@PathVariable Integer id)
    {
        return collectionService.getCollectionById(id);
    }

    // ADD COLLECTION TO A CATALOGUE
    @RequestMapping(method = RequestMethod.POST, value="/catalogues/{catalogueId}/addCollections")
    public  void addCollection(@RequestBody Collection c, @PathVariable Integer catalogueId)
    {
        c.setCatalogueID(catalogueId); // test result when removing this line
        collectionService.addCollection(c);
    }

    /**
     * TODO: NOT SURE EXACTLY WHAT THE FUNCTION OF THIS IS (updateCollection() IN YACINE'S CODE)
     * RENAMED TO updateCollectionDescription() BC IT'S EASIER TO NOT HAVE A "TYPE" ATTRIBUTE FOR COLLECTIONS BUT
    // UPDATE COLLECTION
    @ RequestMapping(method = RequestMethod.PUT, value="/catalogues/{catalogueId}/collections/{id}") // MUST ENTER ID WHICH ALREADY EXISTS IN ORDER TO MODIFY DESCRIPTION
     public  void updateCollectionDescription(@RequestBody Collection col , @PathVariable String id)
     {
        System.out.println("description in controller    "+col.getDescription());
        if( col.getDescription() == null)
        {
            collectionService.updateCollectionType(id,col);
        }
        //collectionService.updateCollection(id,col);
        else if (col.getType() == null)
        {
            collectionService.updateCollectionDescription(id, col);
        }
     }
**/
    // DELETE COLLECTION
    @RequestMapping(method = RequestMethod.DELETE, value="/catalogues/{catalogueId}/collections/{id}")
    public  void deleteCollectionById(@PathVariable Integer id, @PathVariable(required = false) String catalogueId)
    {
        collectionService.deleteCollectionById(id);
    }
    
}
