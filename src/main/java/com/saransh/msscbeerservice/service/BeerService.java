package com.saransh.msscbeerservice.service;

import com.saransh.msscbeerservice.web.model.BeerDTO;

import java.util.UUID;

/**
 * Created by CryptSingh1337 on 8/9/2021
 */
public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);
}
