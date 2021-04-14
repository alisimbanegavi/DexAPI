package com.DexAPI.Controller;

import java.util.List;

import com.DexAPI.DTO.CatalogueDTO;
import com.DexAPI.Entity.Catalogue;
import com.DexAPI.Service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController // this annotation marks class as spring boot rest api contoller
public class CatalogueController 
{
    @Autowired
    private CatalogueService catalogueService; // we need to access the service methods here in the controller 

    //GET LIST OF ALL CATALOGUES
    @RequestMapping("/catalogues")
    public List<Catalogue> getAllCatalogues()
    {
       return catalogueService.getAllCatalogues();
    }

    @RequestMapping("/cataloguesByUser/{id}")
    public List<Catalogue> getAllCatalogues(@PathVariable Integer id)
    {
        return catalogueService.getAllMyCatalogues(id);
    }

    //FIND CATALOGUE BY ID
    @RequestMapping("/catalogues/{id}") // can also write (method = RequestMethod.GET, value="/catalogues")
    public Catalogue getCatalogueById(@PathVariable Integer id)
    {
        return catalogueService.getCatalogueById(id);
    }

    //FIND CATALOGUES BY DESCRIPTION KEYWORD
    @RequestMapping(method = RequestMethod.GET, value="/catalogues")
    public List<Catalogue> getCataloguesByDescription(@PathVariable String search){
        return catalogueService.getCataloguesByDescription(search);
    }

    // ADD CATALOGUE ( adds one at the time )
    @RequestMapping(method = RequestMethod.POST, value="/addCatalogues")
    public  Catalogue addCatalogue(@RequestBody CatalogueDTO c)
    {
        return catalogueService.addCatalogue(c);
    }

    // UPDATE CATALOGUE DESCRIPTION
     @RequestMapping(method = RequestMethod.PUT, value="/catalogues/{id}") // MUST ENTER ID WHICH ALREADY EXISTS IN ORDER TO MODIFY DESCRIPTION
    // @ResponseBody
     public  void updateCatalogue(@RequestBody Catalogue c, @PathVariable Integer id){
        catalogueService.updateCatalogue(id , c.getDescription());
     }

    // DELETE CATALOGUE BY ID
    @RequestMapping(method = RequestMethod.DELETE, value="/catalogues/{id}")
    public  void deleteCatalogueById(@PathVariable Integer id) {
        catalogueService.deleteCatalogueById(id);
    }
}
