/*package com.stackroute.restuarant.controller;


import com.stackroute.restuarantapp.controller.RestuarantController;
import com.stackroute.restuarantapp.domain.Restuarant;
import com.stackroute.restuarantapp.service.RestuarantService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/*


@SpringBootTest annotation tells Spring Boot to go and look for a
main configuration class (one with @SpringBootApplication for instance), and use that to start a Spring
application context. SpringBootTest loads complete application and injects all the beans which is can be slow.

@WebMvcTest - for testing the controller layer and you need to provide remaining dependencies required
using Mock Objects.
 */
/*@RunWith(SpringRunner.class)
@WebMvcTest
public class RestuarantControllerTest {

@Autowired
    MockMvc mockMvc;

@MockBean
    private Restuarant restuarant;
@MockBean
    private RestuarantService restuarantService;
@InjectMocks
private RestuarantController restuarantController;

@Before
public void setUp(){

    MockitoAnnotations.initMocks(this);
   mockMvc= MockMvcBuilders.standaloneSetup(restuarantController).build();
   restuarant = new Restuarant();
    restuarant.setRating_text("Nice Movie");
    restuarant.setAverage_cost_for_two(1500);
    restuarant.setCity("Bangalore");
    restuarant.setCuisines("Chinese");
    restuarant.setRes_id(1234);
    restuarant.setLocality("Koramangala");
    restuarant.setName("Meghna");
    restuarant.setPrice_range(900);
}





}*/
