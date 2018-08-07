package com.stackroute.restuarantapp.controller;

import ch.qos.logback.core.CoreConstants;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.stackroute.restuarantapp.constants.RestuarantConstants;
import com.stackroute.restuarantapp.domain.Restuarant;
import com.stackroute.restuarantapp.exception.RestuarantAlreadyExistException;
import com.stackroute.restuarantapp.exception.RestuarantDoesNotExists;
import com.stackroute.restuarantapp.service.RestuarantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path=RestuarantConstants.MAPPING_URL)
public class RestuarantController {

    private RestuarantService restuarantService;

    @Autowired
    public RestuarantController(RestuarantService restuarantService) {
        this.restuarantService = restuarantService;
    }


    @PostMapping(path=RestuarantConstants.RESTUARANT)
    public ResponseEntity<?> saveRestuarant(@RequestBody Restuarant restuarant)
    {
        ResponseEntity responseEntity=null;
        try {
            Restuarant res = restuarantService.saveRestuarant(restuarant);

            responseEntity = new ResponseEntity(res,HttpStatus.CREATED);

        } catch (RestuarantAlreadyExistException e) {
            System.out.println(e.getMessage());
            responseEntity=new  ResponseEntity<>("Message "+e.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    @DeleteMapping(path=RestuarantConstants.RESTUARANT+"/{res_id}")
    public ResponseEntity deleteRestuarant(@PathVariable ("res_id") Integer res_id){
        ResponseEntity responseEntity=null;

        try {
            restuarantService.deleteRestuarant(res_id);
            responseEntity = new ResponseEntity("Restuarant Deleted",HttpStatus.OK);
        } catch (RestuarantDoesNotExists restuarantDoesNotExists) {

            responseEntity = new ResponseEntity(restuarantDoesNotExists.getMessage(),HttpStatus.NOT_FOUND);

        }
        return responseEntity;

    }

    @PutMapping(path=RestuarantConstants.RESTUARANT+"/{res_id}")
    public ResponseEntity updateRestuarant(@PathVariable ("res_id") Integer res_id , @RequestBody Restuarant restuarant){
        ResponseEntity responseEntity=null;

        try {
            restuarantService.updateRestuarantReview(restuarant);

            responseEntity = new ResponseEntity("Review comments updated",HttpStatus.OK);
        } catch (RestuarantDoesNotExists restuarantDoesNotExists) {
            System.out.println(restuarantDoesNotExists);
            responseEntity = new ResponseEntity(restuarantDoesNotExists.getMessage(),HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }


    @GetMapping(path=RestuarantConstants.RESTUARANT)
    public ResponseEntity getAllRestuarant()
    {
        List<Restuarant> fetchedRestuarantList = restuarantService.getAllRestuarant();
        return new ResponseEntity(fetchedRestuarantList,HttpStatus.OK);
    }
}
