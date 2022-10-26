package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Meal;
import za.ac.cput.factory.MealFactory;
import za.ac.cput.service.impl.MealServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meal/")
@Slf4j
public class MealController {

    @Autowired
    private  MealServiceImpl mealService;




    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Meal create(@RequestBody Meal meal) {
        Meal saveChef = MealFactory.createMeal(
                meal.getMealCode(),
                meal.getMealName(),
                meal.getMealPrice(),
                meal.takeAway(),
                meal.getMealStatus());
        return mealService.create(saveChef);
    }

    @RequestMapping("/read/{MealCode}")
    public Meal read(@PathVariable String MealCode){
        return mealService.read(MealCode);
    }


    @PostMapping("/update")
    public Meal update(@RequestBody Meal meal)
    {return mealService.update(meal);}


    @DeleteMapping("/delete/{MealCode}")
    public boolean delete(@PathVariable String MealCode) {
        return mealService.delete(MealCode);
    }

    @GetMapping("/findAll")
    public List<Meal> findAll() {
        return mealService.findAll();
    }

}