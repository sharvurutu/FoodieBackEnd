package com.stackroute.restuarantapp.service;

import com.stackroute.restuarantapp.constants.RestuarantConstants;
import com.stackroute.restuarantapp.domain.Restuarant;
import com.stackroute.restuarantapp.exception.RestuarantAlreadyExistException;
import com.stackroute.restuarantapp.exception.RestuarantDoesNotExists;
import com.stackroute.restuarantapp.repository.RestuarantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestuarantServiceImpl implements RestuarantService {


    private RestuarantRepository restuarantRepository;

       @Autowired
     public RestuarantServiceImpl(RestuarantRepository restuarantRepository) {
        this.restuarantRepository = restuarantRepository;
    }

    @Override
    public Restuarant saveRestuarant(Restuarant restuarant) throws RestuarantAlreadyExistException{
        Optional option = restuarantRepository.findById(restuarant.getRes_id());
        if(option.isPresent())
        {
            throw new RestuarantAlreadyExistException(RestuarantConstants.RESTUARANTALREADYEXIST);
        }
        else
        {
            return restuarantRepository.save(restuarant);

        }



    }

    @Override
    public boolean deleteRestuarant(int res_id) throws RestuarantDoesNotExists{

           boolean flag = restuarantRepository.findById(res_id).isPresent();
           if(flag)
           {
               restuarantRepository.deleteById(res_id);
           }
           else
           {
               flag = false;
               throw new RestuarantDoesNotExists(RestuarantConstants.RESTUARANTDOESNOTEXIST);
           }
           return flag;
    }

    @Override
    public List<Restuarant> getAllRestuarant() {

        return restuarantRepository.findAll();
    }

    @Override
    public Restuarant updateRestuarantReview(Restuarant restuarant) throws RestuarantDoesNotExists {

          Restuarant res = restuarantRepository.findById(restuarant.getRes_id()).orElse(null);
        if(res!= null)
        {

                res.setRating_text(restuarant.getRating_text());
                return restuarantRepository.save(res);

        }
        else
        {

            throw new RestuarantDoesNotExists(RestuarantConstants.RESTUARANTDOESNOTEXIST);
        }


    }
}
