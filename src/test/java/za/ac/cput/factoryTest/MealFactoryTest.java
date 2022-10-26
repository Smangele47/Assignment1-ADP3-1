package za.ac.cput.factoryTest;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Meal;
import za.ac.cput.factory.MealFactory;

import static org.junit.jupiter.api.Assertions.*;
public class MealFactoryTest {
    @Test
    public void test(){
        Meal meal = MealFactory.createMeal( "Mac and Cheese","10011", "787", "false", "cooking");
        System.out.println(meal.toString());
        assertNotNull(meal);
    }
}


