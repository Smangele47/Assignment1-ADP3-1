package za.ac.cput.controllerTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Meal;
import za.ac.cput.factory.MealFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MealControllerTest {

    private static Meal meal1 = MealFactory
            .createMeal("Mac and Cheese",
                    "10011",
                    787,
                    false,
                    "Cooking");

    private static Meal meal2 = MealFactory
            .createMeal("10012",
                    "Witness",
                    150,
                    true,
                    "Ready");


    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String mealURL = "http://localhost:8080/meal";

    private String username = "user";
    private String password = "password";




    @Test
    void a_save1() {
        String url = mealURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Meal> httpEntitySave1 = new HttpEntity<>(meal1, httpHeaders);
        ResponseEntity<Meal> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave1, Meal.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        meal1 = responseEntity.getBody();
        System.out.println("Save Meal: "+ meal1);
        assertEquals(meal1.getMealCode(), responseEntity.getBody().getMealCode());
    }

    @Test
    void b_save2() {
        String url = mealURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Meal> httpEntitySave2 = new HttpEntity<>(meal2, httpHeaders);
        ResponseEntity<Meal> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave2, Meal.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        meal2 = responseEntity.getBody();
        System.out.println("Save Chef: "+ meal2);
        assertEquals(meal2.getMealCode(), responseEntity.getBody().getMealCode());



    }

    @Test
    void c_read() {
        Meal m = null;
        String url = mealURL + "/read/" + meal2.getMealCode();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Meal> request = new HttpEntity<>(m, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Meal> responseCreate = restTemplate.postForEntity(url, request,  Meal.class);
        assertNotNull(meal2.getMealCode(), responseCreate.getBody().getMealCode());


    }

    @Test
    void d_update() {
        Meal update = new Meal.Builder().copy((meal1)).setMealName("Mac and cheese").build();
        String url = mealURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Meal> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the chef: " + url);
        System.out.println("Updated chef: "+ update);
        ResponseEntity<Meal> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Meal.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = mealURL + "/delete" + meal1.getMealCode();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = mealURL + "/findAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                //basic config
                .withBasicAuth("user","password")
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Display All Entries");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}