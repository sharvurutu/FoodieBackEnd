package com.stackroute.restuarantapp.service;

import com.stackroute.restuarantapp.domain.Restuarant;
import com.stackroute.restuarantapp.exception.RestuarantAlreadyExistException;
import com.stackroute.restuarantapp.exception.RestuarantDoesNotExists;
import com.stackroute.restuarantapp.repository.RestuarantRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class RestuarantServiceTest {

     @Mock
    RestuarantRepository restuarantRepository;

     Restuarant restuarant;

     @InjectMocks
     RestuarantServiceImpl restuarantService;

     @Before
     public void setUp(){

         MockitoAnnotations.initMocks(this);
         restuarant = new Restuarant();
         restuarant.setRes_id(1234);
         restuarant.setLocality("Mg road");
         restuarant.setName("Best chinese");
         restuarant.setPrice_range(1200);
         restuarant.setRating_text("Good taste");
         restuarant.setCuisines("Chinese");
         restuarant.setCity("Bangalore");
         restuarant.setAverage_cost_for_two(1500);

     }

     @Test
     public void testSaveRestuarantSuccess() throws RestuarantAlreadyExistException {

         when(restuarantRepository.save(restuarant)).thenReturn(restuarant);
        Restuarant res=  restuarantService.saveRestuarant(restuarant);
         Assert.assertEquals(restuarant,res);


         }

         @Test(expected = RestuarantAlreadyExistException.class)
         public void testSaveRestuarantFailure() throws RestuarantAlreadyExistException {
         when(restuarantRepository.findById(1234)).thenReturn(Optional.of(restuarant));
         when(restuarantRepository.save(restuarant)).thenReturn(restuarant);
        Restuarant res =  restuarantService.saveRestuarant(restuarant);
        }


        @Test
        public void testupdateRestuarant() throws RestuarantDoesNotExists {
            when(restuarantRepository.findById(1234)).thenReturn(Optional.of(restuarant));
            when(restuarantRepository.save(restuarant)).thenReturn(restuarant);
            restuarant.setRating_text("updated review");
            restuarantService.updateRestuarantReview(restuarant);
            Assert.assertEquals(restuarant.getRating_text(),"updated review");
            }

            public void testDeleteRestuarant() throws RestuarantDoesNotExists {
                when(restuarantRepository.findById(restuarant.getRes_id())).thenReturn(Optional.of(restuarant));
                when(restuarantRepository.save(restuarant)).thenReturn(restuarant);
              boolean flag=  restuarantService.deleteRestuarant(restuarant.getRes_id());
              Assert.assertEquals(true,flag);
            }

            public void testGetAllRestuarant()
            {

            }

}
