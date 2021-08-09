package com.saransh.msscbeerservice.service.impl;

import com.saransh.msscbeerservice.domain.Beer;
import com.saransh.msscbeerservice.exceptions.ResourceNotFoundException;
import com.saransh.msscbeerservice.repositories.BeerRepository;
import com.saransh.msscbeerservice.service.BeerService;
import com.saransh.msscbeerservice.web.mappers.BeerMapper;
import com.saransh.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by CryptSingh1337 on 8/9/2021
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository repository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        log.debug("Retrieving Beer with ID: {}", beerId);
        return beerMapper.beerToBeerDTO(
                repository.findById(beerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Beer with ID: " + beerId + " not found"))
        );
    }

    @Override
    @Transactional
    public BeerDTO saveBeer(BeerDTO beerDTO) {
        log.debug("Saving Beer Object");
        Beer savedBeer = repository.save(beerMapper.beerDTOToBeer(beerDTO));
        log.debug("Beer Object saved with ID: {}", savedBeer.getId());
        return beerMapper.beerToBeerDTO(savedBeer);
    }

    @Override
    @Transactional
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        log.debug("Retrieving Beer with ID: {}", beerId);
        Beer beer = repository.findById(beerId)
                .orElseThrow(() -> new ResourceNotFoundException("Beer with ID: " + beerId + " not exists"));

        beer.setBeerName(beerDTO.getBeerName());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setPrice(beerDTO.getPrice());
        beer.setUpc(beerDTO.getUpc());

        repository.save(beer);
        log.debug("Updated Beer with ID: {}", beer.getId());
    }
}
