package za.ac.cput.factoryTest;
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.ChefFactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ChefFactoryTest {
    @Test
    public void test(){
        Chef chef = ChefFactory.createChef( "C001","Smangele", "female", 120000, "cooking");
        System.out.println(chef.toString());
        assertNotNull(chef);
    }
}

