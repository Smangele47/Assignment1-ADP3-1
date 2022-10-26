package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Meal;
import za.ac.cput.repository.MealRepository;
import za.ac.cput.service.MealService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MealServiceImpl implements MealService {

//    private static  MealService service = null;
private static  MealService service;

    @Autowired
    private MealRepository mealRepository;

    @Override
    public Meal create(Meal meal) {
        return this.mealRepository.save(meal);
    }

    @Override
    public Meal read(String MealCode) {
        return this.mealRepository.findById(MealCode)
                .orElse(null);

    }

    @Override
    public Meal update(Meal meal) {
        if (this.mealRepository.existsById(meal.getMealCode())){
            return this.mealRepository.save(meal);}
        return meal;
    }

//
//    @Override
//    public void delete(Meal meal) {
//        this.mealRepository.delete(meal);
//
//    }


    @Override
    public boolean delete(String MealCode) {
        this.mealRepository.deleteById(MealCode);
        if(this.mealRepository.existsById(MealCode)){
            System.out.println("Meal: "+ MealCode + " not Deleted");
            return false;
        }
        else{
            System.out.println("Meal Deleted");
            return true;
        }
    }

    @Override
    public List<Meal> findAll() {
        return this.mealRepository.findAll().stream().collect(Collectors.toList());
    }


}
