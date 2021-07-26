package com.saransh.msscbeerservice.web.mappers;

import com.saransh.msscbeerservice.domain.Beer;
import com.saransh.msscbeerservice.web.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * Created by CryptoSingh1337 on 7/26/2021
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDTO beerDTO);
}
