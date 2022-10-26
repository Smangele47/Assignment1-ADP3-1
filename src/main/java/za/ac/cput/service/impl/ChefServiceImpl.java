package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Chef;
import za.ac.cput.repository.ChefRepository;
import za.ac.cput.service.ChefService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChefServiceImpl implements ChefService {
//    private static  ChefService service = null;
    private static  ChefService service;

    @Autowired
    private ChefRepository chefRepository;

    @Override
    public Chef create(Chef chef) {
        return this.chefRepository.save(chef);
    }

    @Override
    public Chef read(String ChefID) {
        return this.chefRepository.findById(ChefID)
                .orElse(null);

    }

    @Override
    public Chef update(Chef chef) {
        if (this.chefRepository.existsById(chef.getChefID())){
            return this.chefRepository.save(chef);}
        return chef;
    }


    @Override
    public boolean delete(String ChefID) {
        this.chefRepository.deleteById(ChefID);
        if(this.chefRepository.existsById(ChefID)){
            System.out.println("Chef: "+ ChefID + " not Deleted");
            return false;
        }
        else{
            System.out.println("Chef Deleted");
            return true;
        }
    }

    @Override
    public List<Chef> findAll() {
        return this.chefRepository.findAll().stream().collect(Collectors.toList());
    }


}

