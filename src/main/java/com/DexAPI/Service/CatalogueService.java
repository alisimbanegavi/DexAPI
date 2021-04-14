package com.DexAPI.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.DexAPI.DTO.CatalogueDTO;
import com.DexAPI.Entity.Catalogue;
import com.DexAPI.Entity.Collection;
import com.DexAPI.Entity.User;
import com.DexAPI.Repository.CatalogueRepository;
import com.DexAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //  this annotation makes marks class as spring boot service 
public class CatalogueService 
{
    @Autowired // dependency injection annotation 
    private CatalogueRepository catalogueRepository; // instance variable will be injected with @autowired annotation


    @Autowired
    private UserRepository userRepository;
    /*SERVICES*/
     // get all 
     public List<Catalogue> getAllCatalogues()
     {
        List<Catalogue> catalogueEntities = new ArrayList<Catalogue>();
        catalogueRepository.findAll().forEach(catalogueEntities::add);
        return catalogueEntities;
    }
    // GET ALL CATALOGUES FOR THIS USER
    public List<Catalogue> getAllMyCatalogues(Integer userId)
    {
        List<Catalogue> catalogues = new ArrayList<Catalogue>();
        return catalogueRepository.findCataloguesByUserID(userId);
    }
    // get by id
    public Catalogue getCatalogueById(Integer id) {
        return catalogueRepository.findById(id).get();
    }
    //add Catalogue

    public List<Catalogue> getCataloguesByDescription(String search) {
        return catalogueRepository.findCataloguesByDescription(search);
    }

    public Catalogue addCatalogue(CatalogueDTO c)
    {
        Catalogue catalogue = new Catalogue();
        Optional<User> user = userRepository.findById(Integer.parseInt(c.getUserId()));
        List<Collection> collections = new ArrayList<>();
        Collection collection= new Collection();
        collection.setCollectionName(c.getName());
        collection.setDescription(catalogue.getDescription());
        catalogue.setCollections(collections);
        catalogue.setUser(user.get());
        catalogue.setUserID(Integer.parseInt(c.getUserId()));
        catalogue.setDescription(c.getDescription());
        return catalogueRepository.save(catalogue);
	}

	//remove catalogue
    public void deleteCatalogue(Catalogue c){
        catalogueRepository.deleteById(c.getCatalogueID());
	}

    // remove by id
    public void deleteCatalogueById(Integer id){
        catalogueRepository.deleteById(id);
	}

	// update
    public void updateCatalogue(Catalogue c) {
       catalogueRepository.save(c);
	}

    public void updateCatalogue(Integer id, String description) {
        Catalogue c  = catalogueRepository.findById(id).get();
        c.setDescription(description);
        System.out.println("Updated Catalogue description:    "+c.getDescription() );
        catalogueRepository.save(c);
	}
}
