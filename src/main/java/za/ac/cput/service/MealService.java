package za.ac.cput.service;

import za.ac.cput.domain.Meal;
import java.util.List;

public interface MealService  extends IService <Meal, String> {

    List<Meal> findAll();
//
//    Meal update(Meal meal);
//    boolean delete(String MealCode);
}
