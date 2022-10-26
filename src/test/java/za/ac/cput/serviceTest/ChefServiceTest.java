package za.ac.cput.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.service.impl.ChefServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChefServiceTest {


    @Autowired
    private ChefServiceImpl service;

    private final Chef chef =
            ChefFactory.createChef("C001",
                    "Smangele",
                    "Female",
                    "12000",
                    "Cooking");

    @Test
    void a_create() {
        Chef saved = service.create(chef);
        assertEquals(saved.getChefID(), chef.getChefID());
        System.out.println("saved" + saved);
    }

    @Test
    void b_read() {
        Chef read = service.read(chef.getChefID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    //Possible error
    @Test
    void c_update() {
        Chef updated = new Chef.Builder().copy(chef)
                .setChefName("Smangele")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated FirstName " + "" + updated);

    }

    @Test
    void e_delete() {
        boolean done = service.delete("C001");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);

    }

    @Test
    void d_findAll() {
        System.out.println("Display all Chefs");
        System.out.println(service.findAll());

    }

}