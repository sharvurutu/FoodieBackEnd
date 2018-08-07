package com.stackroute.restuarantapp.service;

import com.stackroute.restuarantapp.domain.Restuarant;
import com.stackroute.restuarantapp.exception.RestuarantAlreadyExistException;
import com.stackroute.restuarantapp.exception.RestuarantDoesNotExists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestuarantService {

     Restuarant saveRestuarant(Restuarant restuarant) throws RestuarantAlreadyExistException;
     boolean deleteRestuarant(int res_id)throws RestuarantDoesNotExists;
     List<Restuarant> getAllRestuarant();
    Restuarant updateRestuarantReview(Restuarant restuarant) throws RestuarantDoesNotExists;

}
