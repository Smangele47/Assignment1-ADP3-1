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
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.ChefFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChefControllerTest {

    private static Chef chef1 = ChefFactory
            .createChef("C001",
                    "Smangele",
                    "Female",
                    12000,
                    "Cooking");

    private static Chef chef2 = ChefFactory
            .createChef("C002",
                    "Witness",
                    "Male",
                    2300,
                    "Ready");


    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String chefURL = "http://localhost:8080/chef";

    private String username = "user";
    private String password = "password";




    @Test
    void a_save1() {
        String url = chefURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Chef> httpEntitySave1 = new HttpEntity<>(chef1, httpHeaders);
        ResponseEntity<Chef> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave1, Chef.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        chef1 = responseEntity.getBody();
        System.out.println("Save Customer: "+chef1);
        assertEquals(chef1.getChefID(), responseEntity.getBody().getChefID());
    }

    @Test
    void b_save2() {
        String url = chefURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Chef> httpEntitySave2 = new HttpEntity<>(chef2, httpHeaders);
        ResponseEntity<Chef> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave2, Chef.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        chef2 = responseEntity.getBody();
        System.out.println("Save Chef: "+ chef2);
        assertEquals(chef2.getChefID(), responseEntity.getBody().getChefID());



    }

    @Test
    void c_read() {
        Chef c = null;
        String url = chefURL + "/read/" + chef2.getChefID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Chef> request = new HttpEntity<>(c, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Chef> responseCreate = restTemplate.postForEntity(url, request,  Chef.class);
        assertNotNull(chef2.getChefID(), responseCreate.getBody().getChefID());


    }

    @Test
    void d_update() {
        Chef update = new Chef.Builder().copy((chef1)).setChefName("Smangele").build();
        String url = chefURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Chef> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the chef: " + url);
        System.out.println("Updated chef: "+ update);
        ResponseEntity<Chef> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Chef.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = chefURL + "/delete" + chef1.getChefID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = chefURL + "/findAll";
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