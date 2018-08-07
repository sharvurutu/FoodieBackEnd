package com.stackroute.restuarantapp.repository;


import com.stackroute.restuarantapp.domain.Restuarant;
import com.stackroute.restuarantapp.exception.RestuarantDoesNotExists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;




@RunWith(SpringRunner.class)
//This by default will configure an in-memory embedded database
//The @DataJpaTest uses @Transactional under the hood. this practically works more accurate when u have in
//memory database
@DataJpaTest
//to use  production type database in tests by adding we need to add
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class RestuarantRepositoryTest {


    @Autowired
    private RestuarantRepository restuarantRepository;
    private Restuarant restuarant;

    @Before
    public void setUp()
    {
        restuarant = new Restuarant();
        restuarant.setRating_text("Nice Movie");
        restuarant.setAverage_cost_for_two(1500);
        restuarant.setCity("Bangalore");
        restuarant.setCuisines("Chinese");
        restuarant.setRes_id(1234);
        restuarant.setLocality("Koramangala");
        restuarant.setName("Meghna");
        restuarant.setPrice_range(900);

        System.out.println("inside setup");

    }

    @After
    public void tearDown(){
        System.out.println("tear down");
      restuarantRepository.deleteAll();

    }

    @Test
    public void testSaveRestuarant(){
        System.out.println("inside test");
        restuarantRepository.save(restuarant);
    Restuarant res = restuarantRepository.findById(restuarant.getRes_id()).get();
        Assert.assertEquals(restuarant.getName() , res.getName());

        }

    @Test
    public void testDeleteRestuarant(){

        restuarantRepository.save(restuarant);
        Restuarant res = restuarantRepository.findById(restuarant.getRes_id()).get();
        restuarantRepository.delete(res);
        Assert.assertEquals(Optional.empty(),restuarantRepository.findById(res.getRes_id()));

        }


        @Test
        public void testUpdateRestuarant(){
            restuarantRepository.save(restuarant);
            Restuarant res = restuarantRepository.findById(restuarant.getRes_id()).get();
            Assert.assertEquals(restuarant.getRes_id(), res.getRes_id());
            res.setRating_text("very Nice Movie");
            restuarantRepository.save(res);
            Assert.assertEquals(res.getRating_text(),"very Nice Movie");



        }

        @Test
        public void testGetAllRestuarant(){
        restuarantRepository.save(restuarant);
        restuarant = new Restuarant();
        restuarant.setRes_id(12345);
        restuarant.setRating_text("new movie");
        restuarant.setPrice_range(1500);
        restuarant.setName("Too tasty");
        restuarant.setLocality("Mg Read");
        restuarantRepository.save(restuarant);

        List<Restuarant> list = restuarantRepository.findAll();
        Assert.assertEquals(2,list.size());


        }

//        @Test(expected = RestuarantDoesNotExists.class)
//        public void testdeleteRestuarantNegative()
//        {
//            restuarantRepository.save(restuarant);
//            Restuarant res = restuarantRepository.findById(restuarant.getRes_id()).get();
//            restuarantRepository.delete(res);
//            res = restuarantRepository.findById(restuarant.getRes_id()).get();
//        }



}
