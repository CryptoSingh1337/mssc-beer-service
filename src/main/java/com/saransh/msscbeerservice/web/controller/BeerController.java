package com.saransh.msscbeerservice.web.controller;

import com.saransh.msscbeerservice.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by CryptoSingh1337 on 7/24/2021
 */
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId) {
        // TODO - impl
        return new ResponseEntity<>(
                BeerDTO.builder().build(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> saveBeer(@Validated @RequestBody BeerDTO beerDTO) {
        // TODO - impl
        return new ResponseEntity<>(
                BeerDTO.builder().build(),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<?> updateBeerById(
            @PathVariable UUID beerId,
            @Validated @RequestBody BeerDTO beerDTO
    ) {
        // TODO - impl
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }
}
