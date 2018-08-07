package com.stackroute.restuarantapp.repository;

import com.stackroute.restuarantapp.domain.Restuarant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestuarantRepository extends JpaRepository<Restuarant,Integer> {
}
