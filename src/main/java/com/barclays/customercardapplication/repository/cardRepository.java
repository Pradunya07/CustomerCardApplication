package com.barclays.customercardapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.barclays.customercardapplication.model.Card;

public interface cardRepository extends CrudRepository<Card,Integer>{

}
