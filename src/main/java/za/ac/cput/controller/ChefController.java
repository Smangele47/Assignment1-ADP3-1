package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.service.impl.ChefServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chef/")
@Slf4j
public class ChefController {

    @Autowired
    private ChefServiceImpl chefService;

//
//    @Autowired
//    public ChefController(ChefServiceImpl chefService) {
//        this.chefService = chefService;
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Chef create(@RequestBody Chef chef) {
        Chef saveChef = ChefFactory.createChef(
                chef.getChefID(),
                chef.getChefName(),
                chef.getChefGender(),
                chef.getChefSalary(),
                chef.getMealStatus());
        return chefService.create(saveChef);
    }

    @RequestMapping("/read/{ChefID}")
    public Chef read(@PathVariable String ChefID){
        return chefService.read(ChefID);
    }


    @PostMapping("/update")
    public Chef update(@RequestBody Chef chef)
    {return chefService.update(chef);}


    @DeleteMapping("/delete/{ChefID}")
    public boolean delete(@PathVariable String ChefID) {
        return chefService.delete(ChefID);
    }

    @GetMapping("/findAll")
    public List<Chef> findAll() {
        return chefService.findAll();
    }

}
