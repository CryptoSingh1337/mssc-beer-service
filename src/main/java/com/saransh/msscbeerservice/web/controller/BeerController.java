package com.saransh.msscbeerservice.web.controller;

import com.saransh.msscbeerservice.service.BeerService;
import com.saransh.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by CryptoSingh1337 on 7/24/2021
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(
                beerService.getBeerById(beerId),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> saveBeer(@Validated @RequestBody BeerDTO beerDTO) {
        return new ResponseEntity<>(
                beerService.saveBeer(beerDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<?> updateBeerById(
            @PathVariable UUID beerId,
            @Validated @RequestBody BeerDTO beerDTO
    ) {
        beerService.updateBeer(beerId, beerDTO);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }
}
