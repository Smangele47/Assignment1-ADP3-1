package za.ac.cput.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Meal;
import za.ac.cput.factory.MealFactory;
import za.ac.cput.service.impl.MealServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MealServiceTest {

    @Autowired
    private MealServiceImpl service;

    private final Meal meal =
            MealFactory.createMeal("Mac and Cheese",
                    "10011",
                    "787",
                    "false",
                    "Cooking");

    @Test
    void a_create() {
        Meal saved = service.create(meal);
        assertEquals(saved.getMealCode(), meal.getMealCode());
        System.out.println("saved" + saved);
    }

    @Test
    void b_read() {
        Meal read = service.read(meal.getMealCode());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    //Possible error
    @Test
    void c_update() {
        Meal updated = new Meal.Builder().copy(meal)
                .setMealName("Mac and Cheese")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated FirstName " + "" + updated);

    }

    @Test
    void e_delete() {
        boolean done = service.delete("10011");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);

    }

    @Test
    void d_findAll() {
        System.out.println("Display Meal List");
        System.out.println(service.findAll());

    }
}