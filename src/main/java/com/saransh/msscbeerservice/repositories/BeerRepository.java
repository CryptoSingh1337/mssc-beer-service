package com.saransh.msscbeerservice.repositories;

import com.saransh.msscbeerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by CryptoSingh1337 on 7/25/2021
 */

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
